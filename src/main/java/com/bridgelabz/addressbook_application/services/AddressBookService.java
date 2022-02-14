package com.bridgelabz.addressbook_application.services;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import com.bridgelabz.addressbook_application.exceptions.AddressBookException;
import com.bridgelabz.addressbook_application.model.AddressBook_attributes;
import com.bridgelabz.addressbook_application.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j

public class AddressBookService implements  IFAddressBookServices{
    @Autowired
    private AddressBookRepository addressBookRepository;
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

    @Override
    public List<AddressBook_attributes> getAllAddressBooksInList() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook_attributes getAddressBookDataById(long id) throws AddressBookException {
        Optional<AddressBook_attributes> findAddressBook = addressBookRepository.findById(id);
        if(!findAddressBook.isPresent()) {
            throw new AddressBookException("ID not found."); // throw custom exception.
        }
        else {
            return findAddressBook.get();
        }
    }

    @Override
    public List<AddressBook_attributes> getAddressBooksByCity(String city) {
        return addressBookRepository.findAddressBooksByCity(city);
    }

    @Override
    public AddressBook_attributes createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook_attributes addressBook_attributes = new AddressBook_attributes(addressBookDTO);
        log.info("Address Book data :- " + addressBook_attributes.toString());
        return addressBookRepository.save(addressBook_attributes);
    }

    @Override
    public AddressBook_attributes updateAddressBookById(AddressBookDTO addressBookDTO, String id) throws AddressBookException {
        Optional<AddressBook_attributes> findAddressBook = addressBookRepository.findById(Long.parseLong(id));
        if (!findAddressBook.isPresent()) {
            throw new AddressBookException("ID not found."); // throw custom exception.
        }
        else {
            return addressBookRepository.save(new AddressBook_attributes(Long.parseLong(id) , addressBookDTO));
        }
    }

    @Override
    public String deleteAddressBookById(long id) {
        Optional<AddressBook_attributes> addressBook_attributes = addressBookRepository.findById(id);
        if (addressBook_attributes.isPresent()) {
            addressBookRepository.deleteById(id);
            return "Deleted AddressBook details successfully.";
        } else {
            return "AddressBook details not found in database.";
        }
    }
}
