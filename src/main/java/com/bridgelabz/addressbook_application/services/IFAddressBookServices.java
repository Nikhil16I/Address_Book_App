package com.bridgelabz.addressbook_application.services;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import com.bridgelabz.addressbook_application.model.AddressBook_attributes;

import java.util.List;

public interface IFAddressBookServices {

    public List<AddressBook_attributes> getAllAddressBooksInList();

    public String Welcome();

    public AddressBook_attributes getAddressBookDataById(long id);

    public AddressBook_attributes createAddressBook(AddressBookDTO addressBookDTO);

    public AddressBook_attributes updateAddressBookById(AddressBookDTO addressBookDTO, String id);

    public String deleteAddressBookById(long id);
}

