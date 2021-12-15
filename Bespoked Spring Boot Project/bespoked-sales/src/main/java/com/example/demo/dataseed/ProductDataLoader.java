package com.example.demo.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
/***
 * 
 * @author sonal
 * Loads the data of product table.
 */
@Component
@Order(2)
public class ProductDataLoader implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadProductData();
	}
	
	private void loadProductData() {
		
		
		if (productRepository.count() == 0) {
			
			Product p1 = new Product("ETHOS 7","Guardian Bikes","Road Bike",200,300,2,10);
			Product p2 = new Product("Highland","Hyper Bicycle","Mountain Bike",180,200,2,20);
			Product p3 = new Product("Thrasher 24","Schwinn Signature","Road Bike",230,300,2,10);
			try {
				productRepository.save(p1);
				productRepository.save(p2);
				productRepository.save(p3);
			}
			catch(Exception e) {
				System.out.println(productRepository.count());
			}
		}
		
			
		
		
	}

}
