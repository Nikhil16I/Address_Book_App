package com.bridgelabz.addressbook_application.model;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
/**Sec-3-UC-1 Using Lombok **/
public class AddressBook_attributes {

    private long id;
    private String full_name;
    private String address;
    private long phone_number;
    private String city;
    private String state;
    private int zip_code;
    private String email;


    public  AddressBook_attributes(AddressBookDTO addressBookDTO) {
        this.full_name = addressBookDTO.full_name;
        this.address = addressBookDTO.address;
        this.phone_number = addressBookDTO.phone_number;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip_code = addressBookDTO.zip_code;
        this.email = addressBookDTO.email;
    }

    public AddressBook_attributes(long id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.full_name = addressBookDTO.full_name;
        this.address = addressBookDTO.address;
        this.phone_number = addressBookDTO.phone_number;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip_code = addressBookDTO.zip_code;
        this.email = addressBookDTO.email;

    }
}
