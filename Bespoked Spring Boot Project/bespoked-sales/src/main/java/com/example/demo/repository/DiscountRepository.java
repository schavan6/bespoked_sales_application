package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{
	
	@Query(value = "SELECT * FROM discount d where d.product_id = :product_id and d.start_date <= :start_date and d.end_date >= :start_date order by discount desc", nativeQuery = true)
    List<Discount> findByProductIdAndDateRange(@Param("product_id") long product_id, @Param("start_date") Date start_date );


}
