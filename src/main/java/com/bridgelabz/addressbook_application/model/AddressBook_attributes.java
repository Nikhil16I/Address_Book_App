package com.bridgelabz.addressbook_application.model;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import lombok.Data;

@Data
public class AddressBook_attributes {

    private long id;
    private String name;
    private String address;

    public AddressBook_attributes() {	}

    public AddressBook_attributes(long id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.name = addressBookDTO.name;
        this.address = addressBookDTO.address;
    }
}
