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
        for (AddressBook_attributes addressBook_attributes : addressBookList) {
            long addressBookID = addressBook_attributes.getId();
            if (addressBookID == id) {
                System.out.println(addressBook_attributes);
                return addressBook_attributes;
            } else {
                continue;
            }
        }
        return null;
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
        AddressBook_attributes addressBookById  = returnAddressBookById(Long.parseLong(id));
        addressBookById.setName(addressBookDTO.name);
        addressBookById.setAddress(addressBookDTO.address);
        return addressBookById;
    }

    @Override
    public String deleteAddressBookById(long id) {
        addressBookList.remove(returnAddressBookById(id));
        String message = "Deleted id :- " + id;
        return message;
    }
}
