package com.bridgelabz.addressbook_application.services;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import com.bridgelabz.addressbook_application.model.AddressBook_attributes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService implements  IFAddressBookServices{

    static List<AddressBook_attributes> addressBookList = new ArrayList<AddressBook_attributes>();
    private static final AtomicLong COUNTER = new AtomicLong(); // to auto increment the id.

    private static AddressBook_attributes returnAddressBookById(long id) {
        return addressBookList.stream().filter(addressBook -> addressBook.getId() == id).findFirst().orElse(null);
    }

    @Override
    public String Welcome() {
        String helloMessage = "Welcome To  The Address Book Application.";
        return helloMessage;
    }

    public List<AddressBook_attributes> getAllAddressBooksInList() {
        List<AddressBook_attributes> allAddressBooks = addressBookList;
        return allAddressBooks;
    }

    @Override
    public AddressBook_attributes getAddressBookDataById(long id) {
        AddressBook_attributes addressBook_attributes = returnAddressBookById(id);
        return addressBook_attributes;
    }

    @Override
    public AddressBook_attributes createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook_attributes addressBook_attributes = new AddressBook_attributes(COUNTER.incrementAndGet(), addressBookDTO);
        addressBookList.add(addressBook_attributes);
        return addressBook_attributes;
    }

    @Override
    public AddressBook_attributes updateAddressBookById(AddressBookDTO addressBookDTO, String id) {
        AddressBook_attributes addressBookById = returnAddressBookById(Long.parseLong(id));
        addressBookById.setFull_name(addressBookDTO.full_name);
        addressBookById.setAddress(addressBookDTO.address);
        addressBookById.setPhone_number(addressBookDTO.phone_number);
        addressBookById.setCity(addressBookDTO.city);
        addressBookById.setState(addressBookDTO.state);
        addressBookById.setZip_code(addressBookDTO.zip_code);
        return addressBookById;
    }

    @Override
    public String deleteAddressBookById(long id) {
        addressBookList.remove(returnAddressBookById(id));
        String message = "Deleted id :- " + id;
        return message;
    }
}
