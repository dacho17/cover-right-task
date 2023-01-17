package com.coverright.codingtask.clients;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.coverright.codingtask.clients.interfaces.ZipCodeClient;
import com.coverright.codingtask.dtos.ZipCodeDetails;

@Component
@ConditionalOnProperty(
	value = "zipcodebase",
	havingValue = "local"
)
public class ZipCodeMockClient implements ZipCodeClient {
	
	private final Map<String, List<ZipCodeDetails>> localZipCodeRepository = Map.of(
		"40361", Arrays.asList(new ZipCodeDetails("Kings", "NY"))
	);

	@Override
	public List<ZipCodeDetails> getZipCodeDetails(String zip) {
		return localZipCodeRepository.get(zip);
	}
}
