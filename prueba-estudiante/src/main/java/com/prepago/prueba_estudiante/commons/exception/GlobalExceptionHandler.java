package com.prepago.prueba_estudiante.commons.exception;

import com.prepago.prueba_estudiante.commons.util.Shield;
import com.prepago.prueba_estudiante.commons.util.Utilities;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> exceptionHandler(RuntimeException ex, HttpServletRequest request) {
        LOGGER.error("RuntimeException ", ex);
        var response = new ExceptionMessage();
        response.setTimestamp(Utilities.getTimestampValue());
        response.setMessage(Shield.blindStr(ex.getMessage()));
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
