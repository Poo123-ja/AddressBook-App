package com.bridgelabz.AddressBook_App.Interface;


import com.bridgelabz.AddressBook_App.DTO.AuthUserDTO;
import com.bridgelabz.AddressBook_App.Model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;

}