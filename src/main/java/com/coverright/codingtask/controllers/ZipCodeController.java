package com.coverright.codingtask.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coverright.codingtask.dtos.ResponseObject;
import com.coverright.codingtask.dtos.ZipCodeResult;

import com.coverright.codingtask.services.ZipCodeService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json" })
public class ZipCodeController {

	@Autowired
	private ZipCodeService zipCodeService;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/zip_resolver")
	public ResponseObject<List<ZipCodeResult>> getCountyData(@RequestParam(required = false) String zip) {
		
		if (zip == null || zip.equals("")) {
			return new ResponseObject<List<ZipCodeResult>>("Zip code not provided", null);
		}
	
		try {
			Integer.parseInt(zip);
		} catch (Exception exc) {
			return new ResponseObject<List<ZipCodeResult>>("Zip code provided is incorrect", null);
		}
		
		try {
			return new ResponseObject<List<ZipCodeResult>>("Data fetched successfully!",
					zipCodeService.getCountiesForZip(zip));
		} catch (Exception exc) {
			return new ResponseObject<List<ZipCodeResult>>(exc.getMessage(), null);
		}
	}
}
