package com.bridgelabz.addressbook_application.controller;

import com.bridgelabz.addressbook_application.dto.AddressBookDTO;
import com.bridgelabz.addressbook_application.dto.ResponseDTO;
import com.bridgelabz.addressbook_application.model.AddressBook_attributes;
import com.bridgelabz.addressbook_application.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AdressBook_App_Controller {
@Autowired
private AddressBookService addressBookService;
    /**
     * UC -2 Creating a Rest Controller to demonstrate the various HTTP Methods
     **/

    @RequestMapping(value = {"", "/", "home"})
    public ResponseEntity<String> Welcome() {
        String message = addressBookService.Welcome();
        return new ResponseEntity<String>(message, HttpStatus.OK);    }

    /*** Section-2-UC-1 :- Introducing DTO and Model to AddressBook App. ***/

    /*** Section-2-UC-2 :- Introducing service layer to AddressBook App. ***/

    /* Getting existing Contact by id using GET call Request. */

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable String id) {
        AddressBook_attributes addressBook_attributes = addressBookService.getAddressBookDataById(Long.parseLong(id));
        ResponseDTO responseDTO = new ResponseDTO("Get call Successfull.", addressBook_attributes);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Creating contact in AddressBook by using POST request. */

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook_attributes addressBook_attributes = addressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Post call Successfull.", addressBook_attributes);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Updating Conatct Detail in AddressBook */

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@RequestBody AddressBookDTO addressBookDTO, @PathVariable String id) {
        AddressBook_attributes addressBook_attributes = addressBookService.updateAddressBookById(addressBookDTO, id);
        ResponseDTO responseDTO = new ResponseDTO("Put call Successfull.", addressBook_attributes);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
        /* Deleteing Conatcts in Address Book by using delete Request. */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable long id) {
        String message = addressBookService.deleteAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete call Successfull.", "Deleted id :- " + id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }
}
