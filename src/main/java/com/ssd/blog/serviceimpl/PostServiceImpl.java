package com.ssd.blog.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.entity.Imdb;
import com.ssd.blog.entity.Post;
import com.ssd.blog.exceptions.TittleExistestException;
import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.payload.PostDto;
import com.ssd.blog.repository.PostRepository;

@Service
public class PostServiceImpl {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PostDto sendPost(PostDto dto) {

		Post post = this.modelMapper.map(dto, Post.class);

		try {
			post = postRepository.save(post);
		} catch (Exception e) {
			e.getMessage();
			throw new TittleExistestException(dto.getTitle(), "Allready  " + dto.getTitle() + "   Existed");
		}
		dto = this.modelMapper.map(post, PostDto.class);

		return dto;
	}

	public PagningAndSortingResponse getAllPosts(int pageNo,int size,String sortBy,String sortDir){
		List<PostDto> dtoList = new ArrayList<>();
	      Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
	      
	      Pageable pageable = PageRequest.of(pageNo,size,sort);
			Page<Post>  postList  =postRepository.findAll(pageable);
			
			
			
			

		for (Post post : postList) {
			PostDto dto = new PostDto();
			dto = this.modelMapper.map(post, PostDto.class);
			dtoList.add(dto);
		}

		PagningAndSortingResponse pagningAndSortingResponse =new PagningAndSortingResponse();
		pagningAndSortingResponse.setContent(dtoList);
		pagningAndSortingResponse.setLast(postList.isLast());
		pagningAndSortingResponse.setPageSize(postList.getSize());
		pagningAndSortingResponse.setTotalElements(postList.getTotalElements());
		pagningAndSortingResponse.setPageNo(postList.getNumber());
		pagningAndSortingResponse.setTotalPages(postList.getTotalPages());
		return pagningAndSortingResponse;
	}

	public PostDto getDetailsById(long id) {

		Post post = postRepository.findById(id).orElseThrow();

		return this.modelMapper.map(post, PostDto.class);

	}

	public void deleteDetailsById(long id) {

		postRepository.deleteById(id);

	}

	public PostDto updateDetailsById(long id, PostDto updatedPostDto) {

		Optional<Post> optionalPost = postRepository.findById(id);
		if (!optionalPost.isPresent()) {
			return null;
		}
		Post existingPost = optionalPost.get();

		existingPost.setTitle(updatedPostDto.getTitle());
		existingPost.setContent(updatedPostDto.getContent());
		Post updatedPost = postRepository.save(existingPost);

		return modelMapper.map(updatedPost, PostDto.class);
	}

}
