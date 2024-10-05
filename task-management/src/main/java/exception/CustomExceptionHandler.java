package exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> 
						handleContraintValidator(ConstraintViolationException ex){
		
		List<Error> errors = new ArrayList<>();
		
		for( final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			Error error = new Error(violation.getPropertyPath().toString(), violation.getMessage());
			errors.add(error);
		}
		
		ErrorResponse response = new ErrorResponse(errors);
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        }
        ErrorResponse response = new ErrorResponse(errors);
        return ResponseEntity.badRequest().body(response);
    }
}
