package com.coverright.codingtask.dtos;

import java.util.List;
import java.util.Map;

import com.coverright.codingtask.dtos.deserializers.ZipCodeApiJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ZipCodeApiJsonDeserializer.class)
public class ZipCodeApiResponse {
	public Object query;
	public Map<String, List<ZipCodeDetails>> results;

	public Object getQuery() {
		return query;
	}

	public void setQuery(Object query) {
		this.query = query;
	}

	public Map<String, List<ZipCodeDetails>> getResults() {
		return results;
	}

	public void setResults(Map<String, List<ZipCodeDetails>> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ZipCodeClientResponse [query=" + query + ", results=" + results + "]";
	}
}
