
package com.bridgelabz.AddressBook_App.Repository;



import com.bridgelabz.AddressBook_App.Model.AddressBookModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressBookModel, Long> {
}
