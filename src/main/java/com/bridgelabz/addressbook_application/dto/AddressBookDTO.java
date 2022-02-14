package com.bridgelabz.addressbook_application.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "Full Name cannot be null./Input Name")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Incorrect Name/Name is Invalid.")
    public String full_name;

    @NotNull(message = "Address cannot be null/Enter Address")
    @Pattern(regexp = "^[\\w\\s-,]{2,}$" , message = "Address validation failed./Input Valid Address")
    public String address;

    @NotNull(message = "Phone number cannot be null./Enter Phone Number")
    public long phone_number;

    @Pattern(regexp = "^[A-Za-z\\s]{2,}$" , message = "City validation failed./Invalid Input")
    public String city;

    @Pattern(regexp = "^[A-Za-z\\s]{2,}$" , message = "State validation failed./Invalid Input")
    public String state;

    @NotNull(message = "Zip code cannot be null./Input Zipcode")
    public int zip_code;

    @Email(regexp = "^[\\w+-]+(\\.[\\w+-]+)*@[\\w]+(\\.[\\w]+)?(?=(\\.[A-Za-z_]{2,3}$|\\.[a-zA-Z]{2,3}$)).*$" , message = "Email validation failed/Invalid Email")
    public String email;

}
