
package com.bridgelabz.AddressBook_App.Interface;


import com.bridgelabz.AddressBook_App.DTO.AddressBookDTO;

import java.util.List;

public interface AddressBookInterface {
    List<AddressBookDTO> getAllContacts();
    AddressBookDTO saveContact(AddressBookDTO dto);
}
