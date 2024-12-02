package com.restfulapi.exception;

import com.restfulapi.model.GeneralErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<GeneralErrorResponse> handleBusinessException(BusinessException exception, WebRequest request) {
        GeneralErrorResponse errorResponse = errorResponse(exception,
                request, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<GeneralErrorResponse> handleNullPonterException(NullPointerException exception, WebRequest request) {
        GeneralErrorResponse errorResponse = errorResponse(exception,
                request, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private GeneralErrorResponse errorResponse(RuntimeException exception,
                                               WebRequest request, int httpStatus,
                                               String reasonPhrases) {
        return GeneralErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(httpStatus)
                .error(reasonPhrases)
                .message(exception.getMessage())
                .path(request.getDescription(false))
                .build();
    }
}
