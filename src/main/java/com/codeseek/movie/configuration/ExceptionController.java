package com.codeseek.movie.configuration;

import com.codeseek.movie.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponseDTO> handleAuthenticationException(AuthenticationException authenticationException,
                                                                          ServletWebRequest servletWebRequest) {
        ErrorResponseDTO errorResponseDTO =
                new ErrorResponseDTO(
                        ZonedDateTime.now(),
                        HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                        HttpStatus.UNAUTHORIZED.value(),
                        authenticationException.getMessage(),
                        servletWebRequest.getRequest().getRequestURI());
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.UNAUTHORIZED);
    }
}
