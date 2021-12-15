package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "style")
	private String style;
	
	@Column(name = "purchase_price")
	private int purchase_price;
	
	@Column(name = "sales_price")
	private int sales_price;
	
	@Column(name = "quantity_on_hand")
	private int quantity_on_hand;
	
	@Column(name = "commision_percentage")
	private int commision_percentage;

	
	public Product() {
		
	}
	
	
	public Product(String name, String manufacturer, String style, int purchase_price, int sales_price,
			int quantity_on_hand, int commision_percentage) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.style = style;
		this.purchase_price = purchase_price;
		this.sales_price = sales_price;
		this.quantity_on_hand = quantity_on_hand;
		this.commision_percentage = commision_percentage;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}

	public int getSales_price() {
		return sales_price;
	}

	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}

	public int getQuantity_on_hand() {
		return quantity_on_hand;
	}

	public void setQuantity_on_hand(int quantity_on_hand) {
		this.quantity_on_hand = quantity_on_hand;
	}

	public int getCommision_percentage() {
		return commision_percentage;
	}

	public void setCommision_percentage(int commision_percentage) {
		this.commision_percentage = commision_percentage;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", manufacturer=" + manufacturer + ", style="
				+ style + ", purchase_price=" + purchase_price + ", sales_price=" + sales_price + ", quantity_on_hand="
				+ quantity_on_hand + ", commision_percentage=" + commision_percentage + "]";
	}
	
	
	
	
}
