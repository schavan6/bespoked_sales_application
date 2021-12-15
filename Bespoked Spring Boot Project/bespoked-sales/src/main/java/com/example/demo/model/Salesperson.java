package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "salesperson")
public class Salesperson {

	public Salesperson() {
		
	}





	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long salesperson_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "manager")
	private long manager;
	
	@Column(name = "start_date")
	private Date start_date;
	
	@Column(name = "end_date")
	private Date end_date;

	
	public Salesperson(long salesperson_id,String first_name, String last_name, String address, String phone,
			long manager, Date start_date, Date end_date) {
		super();
		this.salesperson_id = salesperson_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone = phone;
		this.manager = manager;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public long getSalesperson_id() {
		return salesperson_id;
	}

	public void setSalesperson_id(long salesperson_id) {
		this.salesperson_id = salesperson_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getManager() {
		return manager;
	}

	public void setManager(long manager) {
		this.manager = manager;
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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Salesperson [salesperson_id=" + salesperson_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", address=" + address + ", phone=" + phone + ", manager=" + manager + ", start_date="
				+ start_date + ", end_date=" + end_date + "]";
	}
	
	
	
	
}
