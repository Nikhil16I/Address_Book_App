package com.bridgelabz.addressbook_application.services;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import com.bridgelabz.addressbook_application.model.AddressBook_attributes;

public class AddressBookService implements  IFAddressBookServices{
    @Override
    public String Welcome() {
        String helloMessage = "Welcome To  The Address Book Application.";
        return helloMessage;
    }

    @Override
    public AddressBook_attributes getAddressBookDataById(long id) {
        AddressBook_attributes addressBook_attributes = new AddressBook_attributes(1, new AddressBookDTO("Nikhil", "Patil"));
        return addressBook_attributes;
    }

    @Override
    public AddressBook_attributes createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook_attributes addressBook_attributes = new AddressBook_attributes(1, addressBookDTO);
        return addressBook_attributes;
    }

    @Override
    public AddressBook_attributes updateAddressBookById(AddressBookDTO addressBookDTO, String id) {
        AddressBook_attributes addressBook_attributes = new AddressBook_attributes(Long.parseLong(id), addressBookDTO);
        return addressBook_attributes;
    }

    @Override
    public String deleteAddressBookById(long id) {
        String message = "Deleted id :- " + id;
        return message;
    }
}
