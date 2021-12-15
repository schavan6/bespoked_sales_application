package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long discount_id;
	
	@Column(name = "start_date")
	private Date start_date;
	
	@Column(name = "end_date")
	private Date end_date;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "product_id")
	private long product_id;
	
	@ManyToOne
	@JoinColumn(name = "product_id",insertable=false, updatable=false)
	private Product product;
	
	

	public Discount() {
	}


	

	public Discount(Date start_date, Date end_date, int discount, long product_id) {
		super();
		this.start_date = start_date;
		this.end_date = end_date;
		this.discount = discount;
		this.product_id = product_id;
	}




	public long getProduct_id() {
		return product_id;
	}




	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}




	public long getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(long discount_id) {
		this.discount_id = discount_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Discount [discount_id=" + discount_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", discount=" + discount + "]";
	}
	
	

}
