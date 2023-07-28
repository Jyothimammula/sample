package com.ssd.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.payload.PostDto;
import com.ssd.blog.serviceimpl.ErrorMessageGeneratrorValidation;
import com.ssd.blog.serviceimpl.PostServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PostRestController {

	@Autowired
	public PostServiceImpl postServiceImpl;
	@Autowired
	public ErrorMessageGeneratrorValidation errorMsgs;

	@PostMapping("/posts")
	public ResponseEntity<?> sendPost(@Valid @RequestBody PostDto postDto, BindingResult errorResults) {
		if (errorResults.hasErrors()) {
			return errorMsgs.getBindingResultErrors(errorResults);
		} else {
			return new ResponseEntity<PostDto>(postServiceImpl.sendPost(postDto), HttpStatus.CREATED);
		}

	}

	@GetMapping("/posts")
	public ResponseEntity<PagningAndSortingResponse> getAllPosts(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir) {
		return new ResponseEntity<PagningAndSortingResponse>(postServiceImpl.getAllPosts(pageNo,pageSize,sortBy,sortDir), HttpStatus.OK);

	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDto> getDetailsById(@PathVariable long id) {
		return new ResponseEntity<PostDto>(postServiceImpl.getDetailsById(id), HttpStatus.OK);

	}

	@DeleteMapping("/posts/{id}")
	public void deleteDetailsById(@PathVariable long id) {
		postServiceImpl.deleteDetailsById(id);

	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<PostDto> updateDetailsById(@PathVariable long id, @RequestBody PostDto dto) {
		PostDto updatedPost = postServiceImpl.updateDetailsById(id, dto);

		if (updatedPost == null) {

			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(updatedPost);
	}

}
