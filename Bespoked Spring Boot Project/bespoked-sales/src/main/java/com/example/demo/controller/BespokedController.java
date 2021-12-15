package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.SalesReportEntry;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.Sales;
import com.example.demo.model.Salesperson;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DiscountRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.SalespersonRepository;
import com.example.demo.service.BespokedService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class BespokedController {
	
	  
	  @Autowired
	  DiscountRepository discountRepository; 
	  @Autowired
	  ProductRepository productRepository;
	  @Autowired
	  SalespersonRepository salespersonRepository;
	  @Autowired
	  SalesRepository salesRepository;
	  @Autowired
	  CustomerRepository customerRepository;
	  
	  
	  
	  /***
	   * Get all products
	   * @return
	   */
	  @GetMapping("/products")
	  public ResponseEntity<List<Product>> getAllProducts() {
	    try {
	      List<Product> products = new ArrayList<Product>();

	    
    	  productRepository.findAll().forEach(products::add);
	      

	      if (products.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(products, HttpStatus.OK);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * get list of sales persons
	   * @return
	   */
	  @GetMapping("/salespersons")
	  public ResponseEntity<List<Salesperson>> getAllSalespersons() {
	    try {
	      List<Salesperson> salespersons = new ArrayList<Salesperson>();

	    
	      salespersonRepository.findAll().forEach(salespersons::add);
	      

	      if (salespersons.isEmpty()) {
	    	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(salespersons, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /**
	   * get list of customers
	   * @return
	   */
	  @GetMapping("/customers")
	  public ResponseEntity<List<Customer>> getAllCustomers() {
	    try {
	      List<Customer> customers = new ArrayList<Customer>();

	    
	      customerRepository.findAll().forEach(customers::add);
	      

	      if (customers.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(customers, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * get list of sales entries
	   * @return
	   */
	  @GetMapping("/sales")
	  public ResponseEntity<List<Sales>> getAllSales() {
	    try {
	      List<Sales> sales = new ArrayList<Sales>();

	    
	      salesRepository.findAll().forEach(sales::add);
	      

	      if (sales.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(sales, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * get quarter-wise total commission earned by per sales person
	   * @param quarter
	   * @return
	   */
	  @GetMapping("/salesreport")
	  public ResponseEntity<List<SalesReportEntry>> getSalesReport(@RequestParam(required = false) int quarter) {
	    try {
	      List<SalesReportEntry> sales = new ArrayList<SalesReportEntry>();
	      BespokedService bespokedService = new BespokedService(discountRepository,productRepository,salespersonRepository,salesRepository);
	      bespokedService.getSalesReport(quarter).forEach(sales::add);
	      

	      if (sales.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(sales, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * Create new sale
	   * @param sale
	   * @return
	   */
	  @PostMapping("/sales")
	  public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
	    try {
	      BespokedService bespokedService = new BespokedService(discountRepository,productRepository,salespersonRepository,salesRepository);
	      Sales _sale = bespokedService.createASale(sale);
	      return new ResponseEntity<>(_sale, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * Create new customer
	   * @param customer
	   * @return
	   */
	  @PostMapping("/customer")
	  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    try {
	      //BespokedService bespokedService = new BespokedService(discountRepository,productRepository,salespersonRepository,salesRepository);
	      Customer _customer = customerRepository.save(customer);
	      return new ResponseEntity<>(_customer, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  /***
	   * Create new product
	   * @param product
	   * @return
	   */
	  @PostMapping("/product")
	  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	    try {
	      
	      Product _product = productRepository.save(product);
	      return new ResponseEntity<>(_product, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  

	  
	  
	  @PostMapping("/salesperson")
	  public ResponseEntity<Salesperson> createSalesperson(@RequestBody Salesperson salesperson) {
	    try {
	      
	      Salesperson _salesperson = salespersonRepository.save(salesperson);
	      return new ResponseEntity<>(_salesperson, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/salesperson/{id}")
	  public ResponseEntity<Salesperson> getSalesPersonById(@PathVariable("id") long id){
		  
		  Optional<Salesperson> salespersonData = salespersonRepository.findById(id);

		    if (salespersonData.isPresent()) {
		    	Salesperson _sp = salespersonData.get();
		    	return new ResponseEntity<>(_sp, HttpStatus.OK);
		    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  
	  }
	  
	  @PutMapping("/salesperson/{id}")
	  public ResponseEntity<Salesperson> updateSalesPerson(@PathVariable("id") long id, @RequestBody Salesperson sp) {
	    Optional<Salesperson> tutorialData = salespersonRepository.findById(id);

	    if (tutorialData.isPresent()) {
	    	Salesperson _sp = tutorialData.get();
	    	
	    
	      _sp.setFirst_name(sp.getFirst_name());
	      _sp.setLast_name(sp.getLast_name());
	      _sp.setAddress(sp.getAddress());
	      _sp.setPhone(sp.getPhone());
	      _sp.setManager(sp.getManager());
	      _sp.setEnd_date(sp.getEnd_date());
	      _sp.setStart_date(sp.getStart_date());
	      
	      return new ResponseEntity<>(salespersonRepository.save(_sp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
}
