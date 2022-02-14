package com.bridgelabz.addressbook_application.repository;


import com.bridgelabz.addressbook_application.model.AddressBook_attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook_attributes, Long> {


    @Query(value = "SELECT * FROM addressbook_application_db WHERE city = :city", nativeQuery = true)
    List<AddressBook_attributes> findAddressBooksByCity(String city);
}
