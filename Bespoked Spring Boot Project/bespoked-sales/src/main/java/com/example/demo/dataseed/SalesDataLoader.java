package com.example.demo.dataseed;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Sales;
import com.example.demo.repository.SalesRepository;
/***
 * 
 * @author sonal
 * Loads the data of sales discount table.
 */
@Component
@Order(5)
public class SalesDataLoader  implements CommandLineRunner{
	
	@Autowired
	SalesRepository salesRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadSalesData();
	}

	private void loadSalesData() throws ParseException {
		
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (salesRepository.count() == 0) {
			Sales s1 = new Sales(1,1,1,27,sdf.parse("2021-05-05 20:00:00"));
			Sales s2 = new Sales(2,2,1,40,sdf.parse("2021-03-03 20:00:00"));
			Sales s3 = new Sales(3,3,1,30,sdf.parse("2021-08-01 20:00:00"));
			
			Sales s4 = new Sales(3,3,2,30,sdf.parse("2021-02-01 20:00:00"));
			Sales s5 = new Sales(2,2,2,40,sdf.parse("2021-06-01 20:00:00"));
			Sales s6 = new Sales(1,1,2,30,sdf.parse("2021-08-01 20:00:00"));
			
			Sales s7 = new Sales(1,1,3,27,sdf.parse("2021-03-01 20:00:00"));
			Sales s8 = new Sales(2,2,3,36,sdf.parse("2021-07-01 20:00:00"));
			Sales s9 = new Sales(3,3,3,30,sdf.parse("2021-09-01 20:00:00"));
			Sales s10 = new Sales(3,3,1,30,sdf.parse("2021-02-01 20:00:00"));
			
			try {
				salesRepository.save(s1);
				salesRepository.save(s2);
				salesRepository.save(s3);
				
				salesRepository.save(s4);
				salesRepository.save(s5);
				salesRepository.save(s6);
				
				salesRepository.save(s7);
				salesRepository.save(s8);
				salesRepository.save(s9);
				salesRepository.save(s10);
			}
			catch(Exception e) {
				System.out.println(salesRepository.count());
			}
		}
		
			
		
		
	}
}
