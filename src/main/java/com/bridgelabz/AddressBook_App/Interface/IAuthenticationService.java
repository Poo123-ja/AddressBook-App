package com.bridgelabz.AddressBook_App.Interface;

import com.bridgelabz.AddressBook_App.DTO.AuthUserDTO;
import com.bridgelabz.AddressBook_App.DTO.LoginDTO;
import com.bridgelabz.AddressBook_App.Model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO);
    String forgotPassword(String email, String newPassword);
    String resetPassword(String email, String currentPassword, String newPassword);
}