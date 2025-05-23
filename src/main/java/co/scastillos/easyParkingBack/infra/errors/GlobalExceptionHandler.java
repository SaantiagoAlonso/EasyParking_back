package co.scastillos.easyParkingBack.infra.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseErrorDto> UserNotFoundExeption404(NoSuchElementException ex){
        ResponseErrorDto errorDto = ResponseErrorDto.builder()
                .field("id")
                .error(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseErrorDto> handleValidationExceptions(HttpMessageNotReadableException ex) {

        String fullErrorMessage = ex.getMessage();

        String problemMessage = "Unknown error";
        if (fullErrorMessage != null && !fullErrorMessage.isEmpty()) {
            int startIndex = fullErrorMessage.indexOf("problem:");
            if (startIndex != -1) {
                problemMessage = fullErrorMessage.substring(startIndex).trim();
            } else {
                problemMessage = fullErrorMessage.trim();
            }
        }

        ResponseErrorDto responseErrorDto = ResponseErrorDto.builder()
                .field("incorrect fields")
                .error(problemMessage)
                .build();

        return new ResponseEntity<>(responseErrorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleBlanckValidationExceptions(MethodArgumentNotValidException ex) {

        FieldError fieldError = ex.getBindingResult().getFieldError();

        if (fieldError == null) {
            // Si no hay errores de campo, devolver un mensaje genérico
            ResponseErrorDto responseErrorDto = ResponseErrorDto.builder()
                    .field("unknown")
                    .error("Validation failed")
                    .build();
            return new ResponseEntity<>(responseErrorDto, HttpStatus.BAD_REQUEST);
        }

        ResponseErrorDto responseErrorDto = ResponseErrorDto.builder()
                .field(fieldError.getField())
                .error(fieldError.getDefaultMessage())
                .build();

        return new ResponseEntity<>(responseErrorDto, HttpStatus.BAD_REQUEST);
    }


}

