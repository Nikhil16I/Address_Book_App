package com.bridgelabz.addressbook_application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
/**Sec-3-UC-1 Using Lombok **/
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

}
