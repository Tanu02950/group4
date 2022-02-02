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

import com.siri.proj.java.onlinevegetablesale.entity.Feedback;
import com.siri.proj.java.onlinevegetablesale.service.FeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	FeedbackService  feedbackService;
	@PostMapping("/feedbacks")
	public Feedback addFeedback(@Valid @RequestBody  Feedback  feedback)
	{
		return  feedbackService.addFeedback(feedback);
	}
	
	@GetMapping("/feedbacks")
	public List<Feedback>  getFeedback()
	{
		return  feedbackService.getFeedback();
	}
	
	@DeleteMapping("/feedbacks")
	public  boolean deleteAllFeedbacks()
	{
		return feedbackService.deleteAllFeedbacks();
	}
	@PutMapping("/feedbacks/{feedbackId}")
	public Feedback updateFeedback(@PathVariable int feedbackId, @RequestBody Feedback obj)
	{
		return feedbackService.updateFeedback(feedbackId, obj);
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
