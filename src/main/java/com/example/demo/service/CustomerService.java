package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.CustomerVO;

import lombok.Setter;

@Service
@Setter
public class CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	public List<CustomerVO> findAll(){
		List<CustomerVO> list = null;
		list = dao.findAll();
		return list;
	}
	
	public void save(CustomerVO c) {
		dao.save(c);
	}
	
	public CustomerVO getCustomer(int custid) {
		return dao.getOne(custid);
	}
	
	public int getNextNO() {
		return dao.getNextNO();
	}
	
	public void delete(int custid) {
		dao.deleteById(custid);
	}
	
}
