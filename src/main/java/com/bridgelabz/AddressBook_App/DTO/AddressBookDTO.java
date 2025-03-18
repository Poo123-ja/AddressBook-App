
package com.bridgelabz.AddressBook_App.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private Long id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Name must start with a capital letter and contain only letters and spaces")
    private String name;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    public AddressBookDTO(long l, String johnDoe, String number) {
    }
}

