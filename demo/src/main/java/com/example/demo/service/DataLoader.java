package com.example.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.example.demo.model.Weather;

@Service
public class DataLoader {

	public List<Weather> loadData(String stationId) throws IOException, URISyntaxException {
		System.out.println("data load begin - " + LocalTime.now());

		Map<String, List<Weather>> map = new HashMap<>();
		List<Weather> result = new ArrayList<>();

		int workChunk = 5000;

		Reader in = new FileReader("C:\\Users\\WIN10USER\\Desktop\\EnergyBot\\recordings2017.csv");

		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

		Deque<Spliterator<CSVRecord>> spliterators = new ArrayDeque<>();
		spliterators.add(records.spliterator());
		int totalSplits = 0;

		while (!spliterators.isEmpty()) {
			Spliterator<CSVRecord> spliterator = spliterators.pop();
			Spliterator<CSVRecord> prefix;

			while (spliterator.estimateSize() > workChunk && (prefix = spliterator.trySplit()) != null) {
				spliterators.push(spliterator);
				spliterator = prefix;
			}
			totalSplits++;

			spliterator.forEachRemaining(record -> {
				map.computeIfAbsent(record.get(0), k -> new ArrayList<>()).add(new Weather(record.get(1), record.get(2),
						record.get(3), record.get(4), record.get(5), record.get(6), record.get(7)));
			});

			List<Weather> tempList = map.get(stationId);
			if (null != tempList)
				result.addAll(tempList);
			map.clear();

		}

		System.out.println("total splits - " + totalSplits);
		System.out.println("data load done - " + LocalTime.now());
		return result;
	}

}
