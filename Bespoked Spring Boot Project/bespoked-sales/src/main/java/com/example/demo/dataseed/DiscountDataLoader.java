package com.example.demo.dataseed;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;
/***
 * 
 * @author sonal
 * Loads the data of customer discount table.
 */
@Component
@Order(4)
public class DiscountDataLoader  implements CommandLineRunner{

	@Autowired
	DiscountRepository discountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadDiscountData();
	}
	
	private void loadDiscountData() throws ParseException {
		System.out.println("here");
		
			
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (discountRepository.count() == 0) {
			Discount d1 = new Discount(sdf.parse("2021-01-01 00:00:00"),sdf.parse("2021-12-31 00:00:00"),10,1);
			Discount d2 = new Discount(sdf.parse("2021-06-01 00:00:00"),sdf.parse("2021-12-31 00:00:00"),10,2);
			Discount d3 = new Discount(sdf.parse("2021-08-01 00:00:00"),sdf.parse("2021-12-31 00:00:00"),10,3);
		
			try {
				discountRepository.save(d1);
				discountRepository.save(d2);
				discountRepository.save(d3);
			}
			catch(Exception e) {
				System.out.println(discountRepository.count());
			}
		}
		
	}
		
	
}
