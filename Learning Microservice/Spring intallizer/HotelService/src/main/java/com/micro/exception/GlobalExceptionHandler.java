package com.micro.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
			WebRequest req) {

		MyError err = new MyError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDescription(e.getFieldError().toString());
		err.setPath(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyError> userHandler(HotelException e, WebRequest req) {

		MyError err = new MyError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());

		

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
