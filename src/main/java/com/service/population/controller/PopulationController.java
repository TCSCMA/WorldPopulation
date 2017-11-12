package com.service.population.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.population.bean.WorldPopulation;

@RestController
public class PopulationController {

	
	static String fileName = "population.json";
	static Logger logger = Logger.getLogger(PopulationController.class);
	static List<WorldPopulation> populationByCountryList = new ArrayList<WorldPopulation>();
	
	static {
		InputStream is =
				PopulationController.class.getClassLoader().getResourceAsStream(fileName);
		Type listType = new TypeToken<List<WorldPopulation>>() {}.getType();
		Reader targetReader = new InputStreamReader(is);
		populationByCountryList= new Gson().fromJson(targetReader, listType);
	}
	
	@RequestMapping(value = "/getPopulation", method = RequestMethod.GET)
	public String populationStatusByCountry (@RequestParam String country) {
		logger.info("Service invoked for "+country+" at "+System.currentTimeMillis());
		WorldPopulation returnPopulation = null;
		if (null==country) {
			logger.info("Country not specified in GET");
			return "Specify country in argument";
		}
			
		if (populationByCountryList.isEmpty())
			logger.warn("No data in dataset");
		else {
			for (WorldPopulation wp : populationByCountryList) {
				if (wp.getCountry().equalsIgnoreCase(country)) {
					returnPopulation = wp;
				}
			}
		}
		logger.info("Request served for "+country+" at "+System.currentTimeMillis());
		return returnPopulation.toString();
		
	}
}
