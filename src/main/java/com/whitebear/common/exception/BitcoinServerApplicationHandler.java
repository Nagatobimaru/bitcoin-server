package com.whitebear.common.exception;

import com.whitebear.common.response.ApiResponse;
import com.whitebear.common.response.ApiResponseError;
import com.whitebear.common.utils.HttpStatusUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class BitcoinServerApplicationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<BadRequestException> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(new BadRequestException(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        logger.error(errors, ex);
        ApiResponse apiResponse = new ApiResponseError(errors);
        return new ResponseEntity(apiResponse, HttpStatusUtils.BAD_REQUEST);
    }
}
