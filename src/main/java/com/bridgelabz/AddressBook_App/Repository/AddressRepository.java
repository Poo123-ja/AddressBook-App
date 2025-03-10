
package com.bridgelabz.AddressBook_App.Repository;

import com.bridgelabz.AddressBook_App.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressBookModel,Long> {
}
