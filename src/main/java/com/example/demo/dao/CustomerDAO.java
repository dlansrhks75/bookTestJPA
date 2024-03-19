package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CustomerVO;

@Repository
//@EnableJpaRepositories  //해당 라인은 계속 오류가 발생해서 선생님의 요청으로 오류 메세지에 있는 요청사항에 따라 넣은 어노테이션
public interface CustomerDAO extends JpaRepository<CustomerVO, Integer> {

//	@Query("select nvl(max(custid),0)+1 from CustomerVO")
	@Query(value = "select nvl(max(custid),0)+1 from customer", nativeQuery = true)
	public int getNextNO();
}
