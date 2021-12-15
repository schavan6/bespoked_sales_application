package com.example.demo.bean;
/***
 * 
 * @author sonal
 * Customer bean created to hold sales report 
 * which is quarter-wise aggregation of commission of
 * each sales person
 */
public class SalesReportEntry {

	private long salesperson_id;
	private long commision;
	private long number_of_sales;
	private String salesperson_name;
	private int quarter;
	
	
	public SalesReportEntry(long salesperson_id, String salesperson_name, long commision, long number_of_sales, int quarter) {
		super();
		this.salesperson_id = salesperson_id;
		this.salesperson_name = salesperson_name;
		this.commision = commision;
		this.number_of_sales = number_of_sales;
		this.quarter = quarter;
	}
	public long getSalesperson_id() {
		return salesperson_id;
	}
	public void setSalesperson_id(long salesperson_id) {
		this.salesperson_id = salesperson_id;
	}
	public long getCommision() {
		return commision;
	}
	public void setCommision(long commision) {
		this.commision = commision;
	}
	public long getNumber_of_sales() {
		return number_of_sales;
	}
	public void setNumber_of_sales(long number_of_sales) {
		this.number_of_sales = number_of_sales;
	}
	public String getSalesperson_name() {
		return salesperson_name;
	}
	public void setSalesperson_name(String salesperson_name) {
		this.salesperson_name = salesperson_name;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	
	
	
	
}
