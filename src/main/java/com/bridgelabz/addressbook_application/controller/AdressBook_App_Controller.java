package com.bridgelabz.addressbook_application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AdressBook_App_Controller {
    /** UC -2 Creating a Rest Controller to demonstrate the various HTTP Methods **/

    @RequestMapping(value = { "", "/", "home" })
    public String Welcome() {
        return " Welcome To  The Address Book Application.";
    }
    /* Getting existing Contact by id using GET call Request. */

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<String> getAddressBook(@PathVariable String id) {
        return new ResponseEntity<String>("Get call Successfull.", HttpStatus.OK);
    }

    /* Creating contact in AddressBook by using POST request. */

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAddressBook() {
        return new ResponseEntity<String>("Post call Successfull.", HttpStatus.OK);
    }

    /* Updating Conatct Detail in AddressBook */

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable Long id) {
        return new ResponseEntity<String>("Put call Successfull.", HttpStatus.OK);
    }

    /* Deleteing Conatcts in Address Book by using delete Request. */

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable Long id) {
        return new ResponseEntity<String>("Delete call Successfull.", HttpStatus.OK);
    }
}
