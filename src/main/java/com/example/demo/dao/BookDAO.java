package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer> {

	//정렬하는 쿼리 메소드를 추가해 봅니다.
	public List<BookVO> findAllByOrderByBookid();
	public List<BookVO> findAllByOrderByBookname();
	public List<BookVO> findAllByOrderByPrice();
	public List<BookVO> findAllByOrderByPublisher();
	
	public List<BookVO> findByBookid(Integer keyword);
	public List<BookVO> findByBooknameContaining(String keyword);
	public List<BookVO> findByPrice(Integer keyword);
	public List<BookVO> findByPublisherContaining(String keyword);
	
	public List<BookVO> findByBookidOrderByBookid(Integer keyword);
	public List<BookVO> findByBooknameContainingOrderByBookid(String keyword);
	public List<BookVO> findByPriceOrderByBookid(Integer keyword);
	public List<BookVO> findByPublisherContainingOrderByBookid(String keyword);

	public List<BookVO> findByBookidOrderByBookname(Integer keyword);
	public List<BookVO> findByBooknameContainingOrderByBookname(String keyword);
	public List<BookVO> findByPriceOrderByBookname(Integer keyword);
	public List<BookVO> findByPublisherContainingOrderByBookname(String keyword);
	
	public List<BookVO> findByBookidOrderByPrice(Integer keyword);
	public List<BookVO> findByBooknameContainingOrderByPrice(String keyword);
	public List<BookVO> findByPriceOrderByPrice(Integer keyword);
	public List<BookVO> findByPublisherContainingOrderByPrice(String keyword);
	
	public List<BookVO> findByBookidOrderByPublisher(Integer keyword);
	public List<BookVO> findByBooknameContainingOrderByPublisher(String keyword);
	public List<BookVO> findByPriceOrderByPublisher(Integer keyword);
	public List<BookVO> findByPublisherContainingOrderByPublisher(String keyword);
	
}
