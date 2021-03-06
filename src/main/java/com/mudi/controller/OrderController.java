package com.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.dto.RequestNewOrder;
import com.mudi.repository.OrderRepository;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("form")
	public String form(RequestNewOrder requestNewOrder) {

		return "order/form";

	}

	@PostMapping("new")
	public String newOrder(@Validated RequestNewOrder requestNewOrder, BindingResult bindingResult) {

		orderRepository.save(requestNewOrder.toOrder());
		
		return bindingResult.hasErrors() == true ? "order/form" : "redirect:/home";

	}
}
