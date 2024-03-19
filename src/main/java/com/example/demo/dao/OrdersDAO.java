package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.OrdersVO;

import jakarta.transaction.Transactional;

@Repository
public interface OrdersDAO extends JpaRepository<OrdersVO, Integer> {

	@Query(value = "select nvl(max(orderid),0)+1 from orders", nativeQuery = true)
	public int getNextNo();
	
	@Modifying
	@Query(value = "insert into orders o(o.orderid,o.custid,o.bookid,o.saleprice,o.orderdate) values(:#{#o.orderid},:#{#o.customer.custid},:#{#o.book.bookid},:#{#o.saleprice},sysdate)", nativeQuery = true) // :#{#o.customer.custid}는 아래 메소드의 파라미터인 OrdersVO o에 있는 customer의 custid임을 뜻한다. 
	@Transactional
	public void insert(@Param("o") OrdersVO o);
	
	public List<OrdersVO> findByCustomer_Name(String name);
	
}
