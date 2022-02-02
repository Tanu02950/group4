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

import com.siri.proj.java.onlinevegetablesale.entity.Cart;
import com.siri.proj.java.onlinevegetablesale.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/carts")
	public Cart createCart(@Valid @RequestBody  Cart cart)
	{
		return cartService.createCart(cart);
	}
	
	@GetMapping("/carts")
	public List<Cart> getCart()
	{
		return cartService.getCart();
	}
	
	@DeleteMapping("/carts")
	public  boolean  deleteAllCarts()
	{
		return cartService.deleteAllCarts();
	}
	
	
	@PutMapping("/carts/{cartId}")
	public Cart  updateCart(@PathVariable int cartId, @RequestBody  Cart obj)
	{
		return cartService.updateCart(cartId,obj);
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
