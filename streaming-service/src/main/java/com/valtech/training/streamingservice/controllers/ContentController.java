package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.services.WebSeriesServiceImpl;
import com.valtech.training.streamingservice.vos.MovieVO;


@RestController
@RequestMapping("/api/v1/contents")
public class ContentController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private WebSeriesService webSeriesService; 
	
	@PostMapping("/movies")
	public MovieVO createMovie(@RequestBody MovieVO mvo)  {
		return movieService.createOrUpdate(mvo);
	}
	@GetMapping("/movies")
	public List<MovieVO> getAllMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("/movies/genre/{genre}")
	public List<MovieVO> getAllMoviesByGenre(@PathVariable("genre") String genre){
		return movieService.getMoviesByGenre(genre);
	}
	@GetMapping("/movies/genre/{genre}/language/{language}")
	public List<MovieVO> getAllMoviesByGenreAndLanguage(@PathVariable("genre") String genre,@PathVariable("language") String language){
		return movieService.getMoviesByGenreAndLanguage(genre, language);
	}
	
}
