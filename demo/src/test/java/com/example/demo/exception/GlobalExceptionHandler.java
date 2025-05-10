package com.example.demo.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application, providing RFC 7807-compliant ProblemDetail
 * responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handle validation errors on method arguments (e.g. @Valid request bodies). Returns HTTP 400
   * with all field validation errors listed.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationException(MethodArgumentNotValidException ex) {
    // Create ProblemDetail for Bad Request (400)
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Bad Request");
    problemDetail.setDetail("Validation failed for one or more fields. See 'errors' for details.");

    // Collect field-specific error messages
    List<Map<String, String>> errors = new ArrayList<>();
    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      Map<String, String> errorDetails = new HashMap<>();
      errorDetails.put("field", fieldError.getField());
      errorDetails.put("message", fieldError.getDefaultMessage());
      errors.add(errorDetails);
    }
    // Add the list of field errors as an "errors" property on the ProblemDetail
    problemDetail.setProperty("errors", errors);
    return problemDetail;
  }

  /**
   * Handle constraint violation exceptions (e.g. from @Validated inputs). Returns HTTP 400 with all
   * constraint violations listed.
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ProblemDetail handleConstraintViolationException(ConstraintViolationException ex) {
    // Create ProblemDetail for Bad Request (400)
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Bad Request");
    problemDetail.setDetail("Constraint violation(s) occurred. See 'errors' for details.");

    // Collect constraint violation details
    List<Map<String, String>> errors = new ArrayList<>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      Map<String, String> errorDetails = new HashMap<>();
      errorDetails.put("field", violation.getPropertyPath().toString());
      errorDetails.put("message", violation.getMessage());
      errors.add(errorDetails);
    }
    // Add the list of violations as an "errors" property
    problemDetail.setProperty("errors", errors);
    return problemDetail;
  }

  /**
   * Handle custom application exceptions (e.g. entity not found). Returns HTTP 404 with the
   * exception message as detail.
   */
  @ExceptionHandler(EntityNotFoundException.class) // placeholder for custom not-found exceptions
  public ProblemDetail handleEntityNotFoundException(EntityNotFoundException ex) {
    // Create ProblemDetail for Not Found (404)
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    problemDetail.setTitle("Not Found");
    return problemDetail;
  }

  /** Fallback handler for any other exceptions. Returns HTTP 500 with a generic error detail. */
  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGeneralException(Exception ex) {
    // Create ProblemDetail for Internal Server Error (500)
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    problemDetail.setTitle("Internal Server Error");
    problemDetail.setDetail("An unexpected error occurred.");
    return problemDetail;
  }
}
