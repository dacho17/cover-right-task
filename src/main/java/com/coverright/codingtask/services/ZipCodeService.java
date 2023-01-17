package com.coverright.codingtask.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coverright.codingtask.clients.interfaces.ZipCodeClient;
import com.coverright.codingtask.dtos.ZipCodeDetails;
import com.coverright.codingtask.dtos.ZipCodeResult;

@Service
public class ZipCodeService {

	@Autowired
	private ZipCodeClient zipCodeClient;

	public List<ZipCodeResult> getCountiesForZip(String zip) throws Exception {

		List<ZipCodeDetails> zipCodeDetails = zipCodeClient.getZipCodeDetails(zip);
		
		List<ZipCodeResult> clientResponse = MapApiToClientRes(zipCodeDetails);
		return clientResponse;
	}

	private List<ZipCodeResult> MapApiToClientRes(List<ZipCodeDetails> zipCodeDetails) throws Exception {

		if (zipCodeDetails == null) {
			throw new Exception("No details found for the provided zip code");
		}
		
		List<ZipCodeResult> res = new ArrayList<>();
		for (ZipCodeDetails element : zipCodeDetails) {
			res.add(new ZipCodeResult(element.getProvince(), element.getState_code()));
		}

		return res;
	}
}
