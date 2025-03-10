
package com.bridgelabz.AddressBook_App.Controller;


import com.bridgelabz.AddressBook_App.DTO.AuthUserDTO;
import com.bridgelabz.AddressBook_App.DTO.ResponseDTO;
import com.bridgelabz.AddressBook_App.Model.AuthUser;
import com.bridgelabz.AddressBook_App.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthUserController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> resgister(@Valid @RequestBody AuthUserDTO userDTO) throws Exception{
        AuthUser user = authenticationService.register(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User details submitted!", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
