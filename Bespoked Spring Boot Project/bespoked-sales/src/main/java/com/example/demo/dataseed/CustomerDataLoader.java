package com.example.demo.dataseed;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
/***
 * 
 * @author sonal
 * Loads the data of customer table
 */
@Component
@Order(1)
public class CustomerDataLoader  implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadCustomerData();
	}
	
	private void loadCustomerData() throws ParseException {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (customerRepository.count() == 0) {
			
			Customer c1 = new Customer(1,"John","Doe","123 maple ave","(123)345-9876", sdf.parse("2012-05-31 20:00:00"));
			Customer c2 = new Customer(2,"Jane","Doe","130 maple ave","(123)345-8876", sdf.parse("2020-05-08 20:00:00"));
			Customer c3 = new Customer(3,"Joe","Doe","144 deerfield ave","(123)745-9876", sdf.parse("2012-12-31 20:00:00"));
			try {
				customerRepository.save(c1);
				customerRepository.save(c2);
				customerRepository.save(c3);
			}
			catch(Exception e) {
				System.out.println(customerRepository.count());
			}
		}
		
			
		
		
	}
	
}
