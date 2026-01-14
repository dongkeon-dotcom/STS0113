package com.korea.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProudctRepository extends 
JpaRepository<Product,Long>,
QuerydslPredicateExecutor<Product>{

	List<Product> findAllByOrderByIdxDesc();
	
@Query(value = "select IFNULL(max(idx), 10000) + 1 from product" ,nativeQuery = true)
Long findMaxIdx();
}
