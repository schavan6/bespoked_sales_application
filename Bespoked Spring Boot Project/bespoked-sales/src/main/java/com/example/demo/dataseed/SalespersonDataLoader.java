package com.example.demo.dataseed;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import com.example.demo.model.Salesperson;

import com.example.demo.repository.SalespersonRepository;
/***
 * 
 * @author sonal
 * Loads the data of sales person table.
 */
@Component
@Order(3)
public class SalespersonDataLoader implements CommandLineRunner{
	@Autowired
	SalespersonRepository salespersonRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadSalespersonData();
	}

	private void loadSalespersonData() throws ParseException {
		
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (salespersonRepository.count() == 0) {
			Salesperson s1 = new Salesperson(1,"Dwight","Schrute","123 maple ave","(123)345-9876",1, sdf.parse("2012-05-31 20:00:00"),sdf.parse("2023-05-31 20:00:00"));
			Salesperson s2 = new Salesperson(2,"Jim","Helpert","124 maple ave","(123)349-9876",1, sdf.parse("2013-07-29 20:00:00"),sdf.parse("2023-05-31 20:00:00"));
			Salesperson s3 = new Salesperson(3,"Michale","Scott","126 maple ave","(123)345-9879",1, sdf.parse("2011-02-31 20:00:00"),sdf.parse("2023-05-31 20:00:00"));
			
			try {
				salespersonRepository.save(s1);
				salespersonRepository.save(s2);
				salespersonRepository.save(s3);
				
			}
			catch(Exception e) {
				System.out.println(salespersonRepository.count());
			}
		}
		
		
	}
}
