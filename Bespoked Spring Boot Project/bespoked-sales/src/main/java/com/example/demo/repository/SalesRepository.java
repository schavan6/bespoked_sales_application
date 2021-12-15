package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.SalesReportEntry;
import com.example.demo.model.Sales;



public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	
	@Query(nativeQuery = true)
	List<SalesReportEntry> getSalesReport(@Param("start_date") Date start_date, @Param("end_date") Date end_date, @Param("quarter") int quarter);

}
