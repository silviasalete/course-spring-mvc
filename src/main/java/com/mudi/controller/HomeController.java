package com.mudi.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mudi.model.Order;
@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Order order = new Order();
		order.setName("Extensor de alcance Wi-Fi");
		order.setImage("https://images-na.ssl-images-amazon.com/images/I/41ffko0T3kL.jpg");
		order.setUrl("https://www.amazon.com/-/pt/dp/B00R92CL5E/ref=lp_17938598011_1_2?s=specialty-aps");
		order.setDescription("NETGEAR Extensor de alcance Wi-Fi EX3700 – Cobertura de até 1000 metros quadrados e 15 dispositivos com amplificador e repetidor de sinal sem fio de banda dupla AC750 (até velocidade de 750 Mbps) e design compacto de tomada de parede" + 
				"por NETGEAR");
		
		List<Order> orders = Arrays.asList(order);
		model.addAttribute("orders", orders);
		return "home";
	}
}
