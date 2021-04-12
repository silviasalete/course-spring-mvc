package com.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.model.Status;
import com.mudi.repository.OrderRepository; 
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/{status}")
	public String status(Model model, @PathVariable("status") String status) {
		model.addAttribute("orders", this.orderRepository.findByStatus(Status.valueOf(status.toUpperCase())));
		model.addAttribute("status", status);
		return "home";
	}

	@ExceptionHandler(Exception.class)
	public String handleError() {
		return "home";
	}
}
