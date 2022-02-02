package com.siri.proj.java.onlinevegetablesale.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siri.proj.java.onlinevegetablesale.entity.Address;
import com.siri.proj.java.onlinevegetablesale.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/addresses")
	public Address createAddress(@Valid @RequestBody Address address) {
		return addressService.createAddress(address);
	}

	@GetMapping("/addresses")
	public List<Address> getAddress()

	{
		return addressService.getAddress();

	}

	@DeleteMapping("/addresses")
	public boolean deleteAllAddress() {
		return addressService.deleteAllAddress();
	}

	@PutMapping("/addresses/{addressId} ")
	public Address updateAddress(@PathVariable int addressId, @RequestBody Address obj) {
		return addressService.updateAddress(addressId, obj);

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)

	@ExceptionHandler(MethodArgumentNotValidException.class)

	public Map<String, String> handleValidationExceptions(

			MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();

			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName, errorMessage);

		});

		return errors;
	}

}
