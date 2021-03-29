package com.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mudi.repository.OrderRepository;
@Controller
public class HomeController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		return "home";
	}
}
