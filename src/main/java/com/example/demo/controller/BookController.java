package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.BookVO;
import com.example.demo.service.BookService;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class BookController {

	@Autowired
	private BookService bs;
	
	@GetMapping("/book/detail")
	public void detail(int bookid, Model model) {
		model.addAttribute("b",bs.findById(bookid));
	}
	
	@GetMapping("/book/list")
	public void list(Model model, String keyword, String cname, String sname, HttpSession session) {
		HashMap<String, String> map = new HashMap<String,String>();
		
		String cname2 = null;
		String keyword2 = null;
		
		if(session.getAttribute("keyword") != null) {
			cname2 = (String)session.getAttribute("cname");
			keyword2 = (String)session.getAttribute("keyword");
		}
		
		if(keyword != null) {
			cname2 = cname;
			keyword2 = keyword;
			session.setAttribute("cname", cname2);
			session.setAttribute("keyword", keyword2);
		}
		System.out.println("컨트롤러에서 정렬 컬럼 "+sname);
		
		map.put("keyword", keyword2);
		map.put("cname", cname2);
		map.put("sname",sname);
		model.addAttribute("list",bs.findAll(map));
	}
	
	
	@PostMapping("/book/save")
	public String save(BookVO b) {
		String view = "redirect:/book/list";
		bs.save(b);
		return view;
	}
	
	@GetMapping("/book/update")
	public void updateForm(int bookid, Model model) {
		model.addAttribute("b",bs.findById(bookid));
	}
	
	@GetMapping("/book/delete")
	public String delete(int bookid) {
		String view = "redirect:/book/list";
		bs.delete(bookid);
		return view;
	}
	
}
