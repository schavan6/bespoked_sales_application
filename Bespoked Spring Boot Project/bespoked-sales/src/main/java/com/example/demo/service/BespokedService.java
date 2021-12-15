package com.example.demo.service;


import java.text.ParseException;
import java.util.*;


import com.example.demo.bean.SalesReportEntry;
import com.example.demo.model.Discount;
import com.example.demo.model.Product;
import com.example.demo.model.Sales;
import com.example.demo.model.Salesperson;
import com.example.demo.repository.DiscountRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.SalespersonRepository;



public class BespokedService {
	
	  
	  private DiscountRepository discountRepository; 
	 
	  private ProductRepository productRepository;
	  
	  private SalespersonRepository salespersonRepository;
	  
	  private SalesRepository salesRepository;
	  
	  
	  
	
	public BespokedService(DiscountRepository discountRepository, ProductRepository productRepository,
			SalespersonRepository salespersonRepository, SalesRepository salesRepository) {
		super();
		this.discountRepository = discountRepository;
		this.productRepository = productRepository;
		this.salespersonRepository = salespersonRepository;
		this.salesRepository = salesRepository;
	}
	/**
	 * Before creating a sale, price is updated after applying appropriate discount.
	 * Commission is calculated based on this updated price and commision percentage and saved along with the sale.
	 * @param sale
	 * @return
	 * @throws Exception
	 */
	public Sales createASale(Sales sale) throws Exception {
		
		Optional<Product> productData = productRepository.findById(sale.getProduct_id());
		int discount_percentage = 0;
		Product product = null;
		if (productData.isPresent()) {
			
			product = productData.get();
			
			List<Discount> discountData = discountRepository.findByProductIdAndDateRange(sale.getProduct_id(), sale.getSales_date());
			
			int originalPrice = product.getSales_price();
			int commision = 0;
			
			if (!discountData.isEmpty()) {
				
				discount_percentage = discountData.get(0).getDiscount();
				
				originalPrice = originalPrice - ((originalPrice * discount_percentage)/100);
				
				
			}
			commision = originalPrice * product.getCommision_percentage() /100;
			
			sale.setCommision(commision);
			
			salesRepository.save(sale);
		}
		else {
			throw new Exception("Product not found!");
		}
		return sale;
		
		
		
	}
	
	private Map<Long,String> getIdToNameMap(List<Salesperson> salesPeople){
		
		Map<Long,String> idToName = new HashMap<>();
		
		for(Salesperson sp : salesPeople) {
			idToName.put(sp.getSalesperson_id(),sp.getFirst_name() + " " + sp.getLast_name());
		}
		
		return idToName;
		
		
	}
	/**
	 * Date ranges defining the quarters
	 * @return
	 * @throws ParseException
	 */
	Map<Integer,List<Date>> getQuarterDateMapping() throws ParseException{
		Map<Integer,List<Date>> quarterToDateRange= new HashMap<>();
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = sdf.parse("2021-01-01 00:00:00");
		Date d2 = sdf.parse("2021-03-31 00:00:00");
		Date d3 = sdf.parse("2021-04-01 00:00:00");
		Date d4 = sdf.parse("2021-06-30 00:00:00");
		Date d5 = sdf.parse("2021-07-01 00:00:00");
		Date d6 = sdf.parse("2021-09-30 00:00:00");
		Date d7 = sdf.parse("2021-10-01 00:00:00");
		Date d8 = sdf.parse("2021-12-31 00:00:00");
		
		quarterToDateRange.put(1, new ArrayList<Date>(Arrays.asList(d1,d2)));
		quarterToDateRange.put(2, new ArrayList<Date>(Arrays.asList(d3,d4)));
		quarterToDateRange.put(3, new ArrayList<Date>(Arrays.asList(d5,d6)));
		quarterToDateRange.put(4, new ArrayList<Date>(Arrays.asList(d7,d8)));
		
		return quarterToDateRange;
		
	}
	/***
	 * Get quarter-wise sales report
	 * @param quarter
	 * @return
	 * @throws ParseException
	 */
	public List<SalesReportEntry> getSalesReport(int quarter) throws ParseException {
		
		List<Salesperson> salesPeople = salespersonRepository.findAll();
		
		Map<Long,String> idToName = getIdToNameMap(salesPeople);
		
		Map<Integer,List<Date>> quarterDateMapping = getQuarterDateMapping();
		List<SalesReportEntry>allQuarterSalesEntries = new ArrayList<>();
		if(quarter==0) {
			
			allQuarterSalesEntries.addAll( salesRepository.getSalesReport(quarterDateMapping.get(1).get(0), quarterDateMapping.get(1).get(1),1));
			allQuarterSalesEntries.addAll( salesRepository.getSalesReport(quarterDateMapping.get(2).get(0), quarterDateMapping.get(2).get(1),2));
			allQuarterSalesEntries.addAll( salesRepository.getSalesReport(quarterDateMapping.get(3).get(0), quarterDateMapping.get(3).get(1),3));
			allQuarterSalesEntries.addAll( salesRepository.getSalesReport(quarterDateMapping.get(4).get(0), quarterDateMapping.get(4).get(1),4));
		}
		else {
			allQuarterSalesEntries.addAll( salesRepository.getSalesReport(quarterDateMapping.get(quarter).get(0), quarterDateMapping.get(quarter).get(1),quarter));
		}
		
		
		
		
		for(SalesReportEntry entry : allQuarterSalesEntries) {
			
			entry.setSalesperson_name(idToName.get(entry.getSalesperson_id()));
		}
		
		return allQuarterSalesEntries;
		
		
		
	}
	
	

}
