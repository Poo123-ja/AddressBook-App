
package com.bridgelabz.AddressBook_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AddressBookAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
	}
}
