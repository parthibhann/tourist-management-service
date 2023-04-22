package com.tourism.management.service.config;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tourism.management.service.model.TourismManagementResponse;
import com.tourism.management.service.util.TourismManagementServiceHelper;

import jakarta.xml.bind.ValidationException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class TourismManagementServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ TourismManagementServiceException.class })
	protected ResponseEntity<Object> handleTourismManagementServiceException(final TourismManagementServiceException exception, WebRequest request) {
		String message = exception.getMessage();
		TourismManagementResponse tourismManagementResponse = TourismManagementServiceHelper.createTourismManagementResponse("ERROR", message);
		log.error("handleTourismManagementServiceException > TourismManagementServiceException > " + message );
		return handleExceptionInternal(exception, tourismManagementResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ValidationException.class})
	protected ResponseEntity<Object> handleValidationException(final ValidationException exception, WebRequest request) {
		String message = exception.getLocalizedMessage();
		TourismManagementResponse tourismManagementResponse = TourismManagementServiceHelper.createTourismManagementResponse("ERROR", message);
		log.error("handleTourismManagementServiceException > ValidationException > " + message );
		return handleExceptionInternal(exception, tourismManagementResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String[] errorMessage = prepareErrorMessages(exception);
		TourismManagementResponse tourismManagementResponse = TourismManagementServiceHelper.createTourismManagementResponse("ERROR", "Error while validation", "VALIDATION", errorMessage);
		log.error("handleTourismManagementServiceException > MethodArgumentNotValidException > " + errorMessage );
		return handleExceptionInternal(exception, tourismManagementResponse,  new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private String[] prepareErrorMessages(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getFieldErrors();
		String[] errorMessage = new String[fieldErrors.size()];
		int count = 0;
		for (FieldError fieldError : fieldErrors) {
			errorMessage[count++] = fieldError.getField() +": "+ fieldError.getCode();
		}
		return errorMessage;
	}
	
}
