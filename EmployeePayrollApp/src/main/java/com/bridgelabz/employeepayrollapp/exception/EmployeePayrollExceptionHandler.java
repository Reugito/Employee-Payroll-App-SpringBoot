package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
	
	private static final String MESSAGE = "Exception while processing REST Request";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		log.error("Invalid Date format", exception);
		ResponseDTO respDTO = new ResponseDTO(MESSAGE,"Should have date in the format dd MM yyy");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream()
				.map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO respDTO = new ResponseDTO(MESSAGE, errMsg);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDTO respDTO = new ResponseDTO(MESSAGE, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}
}
