package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.BookVO;

import lombok.Setter;

//@Service
//@Setter
public class BookService2 {

	@Autowired
	private BookDAO dao;
	
	public BookVO findById(int bookid) {
		BookVO b = null;
		//JPA의 finById는 VO를 반환하지 않고 VO를 Optional로 포장해서 반환합니다.
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			b = o.get();
		}
		return b;
	}
	
	
	//pk(주식별자)에 해당하는 레코드가 이미 있으면 update를 수행하고 그렇지 않으면 insert를 수행합니다.
	public List<BookVO> findAll(String keyword, String cname){
		// return dao.findAll();
		if(keyword != null && !keyword.equals("")) {
			return dao.findByBooknameContaining(keyword);
		}
			return dao.findAllByOrderByBookname();
	}
	
	
	public void save(BookVO b) {
		dao.save(b);
	}
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}


	public List<BookVO> findAll(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String cname = map.get("cname");
		String keyword = map.get("keyword");
		List<BookVO> list = null;
		
		if(keyword != null && !keyword.equals("")) {
			switch (cname) {
			case "bookid": list = dao.findByBookid(Integer.parseInt(keyword));break;
			case "bookname": list = dao.findByBooknameContaining(keyword);break;
			case "price": list = dao.findByPrice(Integer.parseInt(keyword));break;
			case "publisher":list = dao.findByPublisherContaining(keyword);
			}
//			아래 처럼 if문을 사용해도 된다.
//			if(cname.equals("bookid")) {
//				return dao.findByBookid(Integer.parseInt(keyword));
//			} else if(cname.equals("bookname")) {
//				return dao.findByBooknameContainingOrderByBookname(keyword);
//			} else if(cname.equals("price")) {
//				return dao.findByPrice(Integer.parseInt(keyword));
//			} else {
//				return dao.findByPublisherContainingOrderByBookname(keyword);
//			}			
		} else {
			return dao.findAllByOrderByBookname();
		}	
		return list;
	}
	
}
