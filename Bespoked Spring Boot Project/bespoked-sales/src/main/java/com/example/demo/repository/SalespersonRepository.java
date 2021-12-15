package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Salesperson;


public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {

}
