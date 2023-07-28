package com.ssd.blog.web;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssd.blog.exceptions.ExceptionDetails;
import com.ssd.blog.exceptions.TittleExistestException;

@ControllerAdvice
public class SSDBlogException {



	@ExceptionHandler(value = TittleExistestException.class)
	public ResponseEntity<ExceptionDetails> exception(TittleExistestException exception) {

		ExceptionDetails ed = new ExceptionDetails(new Date(), exception.getTitle(), exception.getExpMsg());

		return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.NOT_FOUND);

	}

}
