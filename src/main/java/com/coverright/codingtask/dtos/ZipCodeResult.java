package com.coverright.codingtask.dtos;

public class ZipCodeResult {
	
	private String county;
	private String state;

	public ZipCodeResult(String county, String state) {
		this.county = county;
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ZipCodeResult [county=" + county + ", state=" + state + "]";
	}
}
