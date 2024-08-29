package com.rahul.jmrp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rahul.jmrp.response.structure.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler{

	@ExceptionHandler(IdDoesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdDoesNotFoundException(IdDoesNotFoundException e) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMeassage("Not Found...!");
		responseStructure.setData(e.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseStructure<Map<String, String>>> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		Map<String, String> map = new HashMap<>();

		methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			map.put(fieldName, errorMessage);
		});

		responseStructure.setMeassage("Data is not valid, please correct it...!");
		responseStructure.setData(map);
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStructure<String>> handleGenericException(Exception exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseStructure.setMeassage("Bad Request , please correct it...!");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
