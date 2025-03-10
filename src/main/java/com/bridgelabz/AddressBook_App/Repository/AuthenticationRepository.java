package com.bridgelabz.AddressBook_App.Repository;


import com.bridgelabz.AddressBook_App.Model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthUser, Long> {
    @Query(value = "SELECT * FROM AUTH_USER WHERE EMAIL = :email", nativeQuery = true)
    AuthUser findByEmail(@Param("email") String email);
    AuthUser findByResetToken(String resetToken);
}