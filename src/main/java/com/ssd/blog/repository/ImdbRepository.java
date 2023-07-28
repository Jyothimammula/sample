package com.ssd.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.blog.entity.Imdb;

public interface ImdbRepository extends JpaRepository<Imdb,String> {

}
