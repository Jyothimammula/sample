package com.ssd.blog.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.entity.Imdb;
import com.ssd.blog.repository.ImdbRepository;


@Service
public class ImdbServiceImpl {
	
	@Autowired
	public ImdbRepository imdbRepository;

	public List<Imdb> getAllMovies(int pageNo,int size,String sortBy,String sortDir){
		
	      Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo,size,sort);
		Page<Imdb>  page  =imdbRepository.findAll(pageable);
		
		return page.getContent();
	}
	
}
