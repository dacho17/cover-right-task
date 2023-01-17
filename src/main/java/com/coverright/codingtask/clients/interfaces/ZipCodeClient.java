package com.coverright.codingtask.clients.interfaces;

import java.util.List;

import com.coverright.codingtask.dtos.ZipCodeDetails;

public interface ZipCodeClient {
	List<ZipCodeDetails> getZipCodeDetails(String zip) throws Exception;
}
