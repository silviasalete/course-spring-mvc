package com.mudi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.model.StatusOrder;
import com.mudi.repository.OrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping()
	public String home(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		return "home";
	}
	
	@GetMapping("/{status}")
	public String forStatus(Model model, @PathVariable("status") String status) {
		model.addAttribute("orders", orderRepository.findByStatus(StatusOrder.valueOf(status.toUpperCase())));
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(Exception.class)
	public String onError(Exception ex, Model model) {
		System.out.println("*************************** Exception *************************");
		System.out.println("Exception:  "+ex.getClass());
		System.out.println("Mensage..:  "+ex.getMessage());
		System.out.println("**************************************************************");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("class", ex.getClass().toString());
		return "error";
	}
	
}