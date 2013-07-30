package org.pi4j.model;

public class Location {
	
	private long geoname_id;
	private String country_code;
	private String place_type;
	private String place_name;
	private String state;
	private double latitude;
	private double longitude;
	
	public long getGeoname_id() {
		return geoname_id;
	}
	public void setGeoname_id(long geoname_id) {
		this.geoname_id = geoname_id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getPlace_type() {
		return place_type;
	}
	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
