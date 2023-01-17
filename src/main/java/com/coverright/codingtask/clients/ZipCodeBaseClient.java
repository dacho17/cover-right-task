package com.coverright.codingtask.clients;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coverright.codingtask.clients.interfaces.ZipCodeClient;
import com.coverright.codingtask.dtos.ZipCodeApiResponse;
import com.coverright.codingtask.dtos.ZipCodeDetails;

@Component
@ConditionalOnProperty(
	value = "zipcodebase",
	havingValue = "https://app.zipcodebase.com/landing_demo/"
)
public class ZipCodeBaseClient implements ZipCodeClient {

	private final String apiURL = "https://app.zipcodebase.com/landing_demo/";
	private final String countryQueryPar = "&country=US";

	@Override
	public List<ZipCodeDetails> getZipCodeDetails(String zip) throws Exception {

		String finalZipCodeBaseUrl = this.apiURL + "?codes=" + zip + countryQueryPar;
		ZipCodeApiResponse response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.getForObject(finalZipCodeBaseUrl, ZipCodeApiResponse.class);
		} catch (Exception exc) {
			throw new Exception(
				"Error occurred while communicating with ZipBase API. Make sure you inserted the correct zip code.");
		}

		try {
			List<ZipCodeDetails> zipCodeDetails = response.getResults().entrySet().iterator().next().getValue();
			return zipCodeDetails;
		} catch (Exception exc) {
			throw new Exception("Error while deserializing data from the ZipBase API response.");
		}
	}
}
