package com.bridgelabz.addressbook_application.dto;

import lombok.Data;
@Data
/**Sec-3-UC-1 Using Lombok **/

public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
