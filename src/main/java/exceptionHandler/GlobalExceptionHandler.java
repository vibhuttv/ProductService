package exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice    // Annotation matters
public class GlobalExceptionHandler {          // name cane be Anything
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went Wrong [ Controller Advice ] ");
        exceptionDto.setResolution("Arithmetic Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went Wrong [ Controller Advice ] ");
        exceptionDto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Invalid ProductId " + productNotFoundException.getId() + " [ Custom Exceptions ] ");
        exceptionDto.setResolution("ProductNotFoundException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handleGeneralException(){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Something went Wrong [ Controller Advice ] ");
//        exceptionDto.setResolution("General Exception");
//        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//        return response;
//    }

}

