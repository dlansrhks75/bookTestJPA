package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrdersVO {
	
	@Id
	private int orderid;

	@ManyToOne   // --> OrdersVO에는 custid가 여러 개 일 수 있지만, custid를 고유키로 가지는 테이블에서는 custid가 하나여야 한다는 뜻.
	@JoinColumn(name="custid", insertable=true, updatable=true)  // custid로 조인하고 있으며, 외래 키에 대한 삽입(insert) 및 갱신(update)이 가능하도록 지정합니다.
	private CustomerVO customer;
	
	@ManyToOne
	@JoinColumn(name="bookid", insertable=true, updatable=true)
	private BookVO book;
	
	private int saleprice;
	private String orderdate;
}
