package com.bridgelabz.addressbook_application.exceptions;

import com.bridgelabz.addressbook_application.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBook_ExceptionHandler {

    private static final String MESSAGE = "Exception while processing REST request.";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();

        List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errorMessage);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookIdNotFoundException(AddressBookException exception) {
        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
