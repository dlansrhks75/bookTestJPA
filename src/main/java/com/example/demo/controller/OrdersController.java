package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.OrdersVO;
import com.example.demo.service.BookService;
import com.example.demo.service.BookService2;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;

import lombok.Setter;

@Controller
@Setter
public class OrdersController {

	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private OrdersService os;
	
	@GetMapping("/orders/insert")
	public void insert(Model model) {
//		model.addAttribute("bList",bs.findAll());
		model.addAttribute("bList",bs.findAll(null));
		model.addAttribute("cList",cs.findAll());
		model.addAttribute("orderid",os.getNextNo());
	}
	
	@PostMapping("/orders/save")
	public String save(OrdersVO o) {
		String view = "redirect:/orders/insert";
		os.insert(o);
		return view;
	}
	
	@GetMapping("/orders/list")
	public void list(Model model,String name) {
		model.addAttribute("list",os.findAll(name));
	}
	
	
}
