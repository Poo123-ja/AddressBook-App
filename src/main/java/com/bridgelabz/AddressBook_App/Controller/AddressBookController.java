
package com.bridgelabz.AddressBook_App.Controller;



import com.bridgelabz.AddressBook_App.DTO.AddressBookDTO;
import com.bridgelabz.AddressBook_App.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    @GetMapping("/show")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }
    @PostMapping
    public ResponseEntity<AddressBookDTO> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(addressBookService.saveContact(addressBookDTO));
    }
}
