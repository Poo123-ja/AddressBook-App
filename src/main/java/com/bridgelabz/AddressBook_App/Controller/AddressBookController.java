package com.bridgelabz.AddressBook_App.Controller;
import com.bridgelabz.AddressBook_App.DTO.AddressBookDTO;
import com.bridgelabz.AddressBook_App.DTO.ResponseDTO;
import com.bridgelabz.AddressBook_App.Interface.AddressBookInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contacts")
public class AddressBookController {
    @Autowired
    AddressBookInterface service;


    //Get all contacts
    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    // Get a single contact by ID
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<AddressBookDTO> getContactById(@PathVariable Long id) {
        AddressBookDTO contact = service.getContactById(id);
        return (contact != null) ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    // Create a new contact
    @PostMapping("/create")
    public ResponseEntity<?> createContact(@Valid @RequestBody AddressBookDTO dto) {
        AddressBookDTO createContact = service.saveContact(dto);
        return ResponseEntity.ok(new ResponseDTO("Contact created sucessfully", createContact));
    }

    // Update an existing contact
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody AddressBookDTO dto) {
        AddressBookDTO updatedContact = service.updateContact(id, dto);
        return (updatedContact != null) ? ResponseEntity.ok(new ResponseDTO("Contact updated sucessfully", updatedContact)) : ResponseEntity.notFound().build();
    }

    // Delete a contact
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        return (service.deleteContact(id)) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
