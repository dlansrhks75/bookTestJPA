package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
import com.example.demo.entity.OrdersVO;

import lombok.Setter;

@Service
@Setter
public class OrdersService {

	@Autowired
	public OrdersDAO dao;
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void insert(OrdersVO o) {
		dao.insert(o);
	}
	
	public List<OrdersVO> findAll(String name){
		List<OrdersVO> list = null;
		if(name == null || name.equals("")) {
			list = dao.findAll();
		}else {
			list = dao.findByCustomer_Name(name);
		}
		
		return list;
	}
}
