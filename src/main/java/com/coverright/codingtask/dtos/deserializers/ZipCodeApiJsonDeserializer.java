package com.coverright.codingtask.dtos.deserializers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.coverright.codingtask.dtos.ZipCodeApiResponse;
import com.coverright.codingtask.dtos.ZipCodeDetails;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZipCodeApiJsonDeserializer extends JsonDeserializer<ZipCodeApiResponse> {
	
	@Override
	public ZipCodeApiResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Root root = jp.readValueAs(Root.class);
		
		ZipCodeApiResponse zipRes = new ZipCodeApiResponse();
		if (root != null && root.results != null) {
			zipRes.setResults(root.results);
		}
		
		return zipRes;
	}
	
	private static class Root {
		public Object query;
		public Map<String, List<ZipCodeDetails>> results;
	}
}
