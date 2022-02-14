package com.bridgelabz.addressbook_application.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "Full Name cannot be null.")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Incorrect Name/Name is Invalid.")
    public String full_name;
    public String address;
    public long phone_number;
    public String city;
    public String state;
    public int zip_code;

}
