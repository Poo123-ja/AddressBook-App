
package com.bridgelabz.AddressBook_App.Service;


import com.bridgelabz.AddressBook_App.DTO.AddressBookDTO;
import com.bridgelabz.AddressBook_App.Interface.AddressBookInterface;
import com.bridgelabz.AddressBook_App.Model.AddressBookModel;
import com.bridgelabz.AddressBook_App.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements AddressBookInterface {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<AddressBookDTO> getAllContacts(){
        return addressRepository.findAll().stream()
                .map(contact -> new AddressBookDTO(contact.getId(), contact.getName(), contact.getPhone()))
                .collect(Collectors.toList());
    }
    @Override
    public AddressBookDTO saveContact(AddressBookDTO addressBookDTO) {
        AddressBookModel contact = new AddressBookModel();
        contact.setName(addressBookDTO.getName());
        contact.setPhone(addressBookDTO.getPhone());
        AddressBookModel savedContact = addressRepository.save(contact);
        return new AddressBookDTO(savedContact.getId(), savedContact.getName(), savedContact.getPhone());
    }
}
