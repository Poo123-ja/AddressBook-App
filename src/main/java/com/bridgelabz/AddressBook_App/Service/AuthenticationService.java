
package com.bridgelabz.AddressBook_App.Service;


import com.bridgelabz.AddressBook_App.DTO.AuthUserDTO;
import com.bridgelabz.AddressBook_App.Interface.IAuthenticationService;
import com.bridgelabz.AddressBook_App.Model.AuthUser;
import com.bridgelabz.AddressBook_App.Repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    AuthenticationRepository authUserRepository;

    @Override
    public AuthUser register(AuthUserDTO userDTO) throws Exception {
        AuthUser user = new AuthUser(userDTO);

        authUserRepository.save(user);

        return user;
    }


}
