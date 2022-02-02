package com.siri.proj.java.onlinevegetablesale.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.siri.proj.java.onlinevegetablesale.entity.Vegetable;
import com.siri.proj.java.onlinevegetablesale.service.VegetableService;


@RestController
public class VegetableController {
	@Autowired
	VegetableService  vegetableService;
	@PostMapping("/vegetables")
	public  Vegetable   addVegetable(@Valid @RequestBody  Vegetable vegetable)
	{
		return  vegetableService.addVegetable(vegetable);
		
	}
	
	@GetMapping("/vegetables")
	public  List<Vegetable>  getVegetable()
	{
		return vegetableService.getVegetable();
	}
	
	@DeleteMapping("/vegetables")
	public boolean  deleteAllVegetable()
	{
		return vegetableService.deleteAllVegetable();
	}
	
	@PutMapping("/Vegetables/{vegId}")
	public Vegetable  updateVegetable(@PathVariable int vegId, @RequestBody Vegetable obj)
	{
		return vegetableService.updateVegetable(vegId, obj);
		
	}
	
	@GetMapping("/vegetables/{vegId}")
	public Vegetable getVegetableById(@PathVariable int vegId) {
		return vegetableService.getVegetableById(vegId);
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


