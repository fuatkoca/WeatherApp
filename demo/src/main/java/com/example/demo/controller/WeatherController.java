package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Weather;
import com.example.demo.model.WeatherDTO;
import com.example.demo.service.DataLoader;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final DataLoader service;

	@Autowired
	private WeatherController(DataLoader service) {
		this.service = service;
	}

	@GetMapping("/get-by-id/{stationId}")
	public ResponseEntity<WeatherDTO> getById(@PathVariable String stationId) throws IOException, URISyntaxException {
		List<Weather> list = service.loadData(stationId);

		if (null == list)
			throw new ResourceNotFoundException("Couldn't find station id!");

		return ResponseEntity.ok(new WeatherDTO(stationId, list));
	}

}
