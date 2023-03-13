package com.products.core.productsbackend.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Object> processUnmergeException(final MethodArgumentNotValidException ex) {

		Map<String, String> data = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach(e -> data.put(e.getField(), e.getDefaultMessage()));

		Map<String, Object> format = new HashMap<String, Object>();
		format.put("status", false);
		format.put("errors", data);

		return new ResponseEntity<>(format, HttpStatus.BAD_REQUEST);
	}
}