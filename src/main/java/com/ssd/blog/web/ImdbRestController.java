package com.ssd.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.entity.Imdb;
import com.ssd.blog.serviceimpl.ImdbServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ImdbRestController {
	
	@Autowired
	public ImdbServiceImpl service;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Imdb>> getAllMovies(	
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "series_Title", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir){
		
		List<Imdb> movieList = service.getAllMovies(pageNo,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<List<Imdb>>(movieList,HttpStatus.OK);
	}

}
