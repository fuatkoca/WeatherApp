package com.example.demo.model;

import java.util.List;

public class WeatherDTO {

	private String stationId;
	private List<Weather> weatherList;

	public WeatherDTO(String stationId, List<Weather> weatherList) {
		super();
		this.stationId = stationId;
		this.weatherList = weatherList;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public List<Weather> getWeatherList() {
		return weatherList;
	}

	public void setWeatherList(List<Weather> weatherList) {
		this.weatherList = weatherList;
	}
	
}
