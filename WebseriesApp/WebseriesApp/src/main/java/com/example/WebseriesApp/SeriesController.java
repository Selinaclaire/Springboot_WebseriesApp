package com.example.WebseriesApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeriesController {	
		@Autowired
		private SeriesRepository seriesrepository;
		
		@GetMapping("/series")
		public List<Series> getSeries(){
			return seriesrepository.findAll();
		}
		
		@GetMapping("/seriesbyid")
		public List<Series> getId(@RequestParam int id){
			return seriesrepository.findById(id);
		}
		
		@GetMapping("/seriesbyname")
		public List<Series> getGenre(@RequestParam String name){
			return seriesrepository.findByName(name);
		}
		
		@GetMapping("/addSeries")
		@ResponseBody
		public String addSeries() {
			
			int id = 101;
			String name = "Webseries 1";
			String seasons = "1";
			String episodes = "8";
			String rating = "10";
			
			Series cout = new Series(id,name,seasons,episodes,rating);
			seriesrepository.save(cout);
			System.out.println("----------All Data saved into Database--------------");
			return "[{status:inserted}]";
		}
		
		@GetMapping("/update")
		public String updateSeries() {

			int id = 9;
			String name = "Series Name Updated";
			String seasons = "10";
			String episodes = "15";
			String rating = "19";
			
			Series cout = new Series(id,name,seasons,episodes,rating);
			seriesrepository.save(cout);
			return "[{status:edited}]";
		}
		

}
