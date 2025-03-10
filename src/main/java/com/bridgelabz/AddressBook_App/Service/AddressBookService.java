package com.bridgelabz.AddressBook_App.Service;



import com.bridgelabz.AddressBook_App.DTO.AddressBookDTO;
import com.bridgelabz.AddressBook_App.Interface.AddressBookInterface;
import com.bridgelabz.AddressBook_App.Model.AddressBookModel;
import com.bridgelabz.AddressBook_App.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements AddressBookInterface {
    @Autowired
    private AddressRepository repository;

    // Retrieve all contacts
    @Override
    public List<AddressBookDTO> getAllContacts() {
        return repository.findAll().stream()
                .map(contact -> new AddressBookDTO(contact.getId(), contact.getName(), contact.getPhone()))
                .collect(Collectors.toList());
    }

    // Save a new contact
    @Override
    public AddressBookDTO saveContact(AddressBookDTO dto) {
        AddressBookModel contact = new AddressBookModel();
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        AddressBookModel savedContact = repository.save(contact);
        return new AddressBookDTO(savedContact.getId(), savedContact.getName(), savedContact.getPhone());
    }

    // Retrieve a single contact by ID
    @Override
    public AddressBookDTO getContactById(Long id) {
        Optional<AddressBookModel> contact = repository.findById(id);
        return contact.map(c -> new AddressBookDTO(c.getId(), c.getName(), c.getPhone()))
                .orElse(null);  // Returns null if contact is not found
    }

    //  Update an existing contact by ID
    @Override
    public AddressBookDTO updateContact(Long id, AddressBookDTO dto) {
        Optional<AddressBookModel> existingContact = repository.findById(id);

        if (existingContact.isPresent()) {
            AddressBookModel contact = existingContact.get();
            contact.setName(dto.getName());
            contact.setPhone(dto.getPhone());
            AddressBookModel updatedContact = repository.save(contact);
            return new AddressBookDTO(updatedContact.getId(), updatedContact.getName(), updatedContact.getPhone());
        }
        return null;
    }


    @Override
    public boolean deleteContact(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}