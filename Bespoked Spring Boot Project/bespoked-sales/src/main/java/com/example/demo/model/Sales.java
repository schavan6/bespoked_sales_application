package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.Table;
import com.example.demo.bean.SalesReportEntry;



@Entity
@Table(name = "sales")

/**
 * 
 * @author sonal
 * Mapping below is created so that result of named native query can be mapped to  custom class
 * (not mapped to an entity).
 */
@SqlResultSetMapping(name = "SalesReportMapping", 
classes = @ConstructorResult(
        targetClass = SalesReportEntry.class, 
        columns = {@ColumnResult(name = "salesperson_id",type=Long.class),
        	   @ColumnResult(name = "salesperson_name",type=String.class),
               @ColumnResult(name = "commision",type=Long.class),
               @ColumnResult(name = "number_of_sales",type=Long.class),
               @ColumnResult(name = "quarter",type=Integer.class)}
        )
)
//named native query declared here, used in SalesRepository class in getSalesReport method
@NamedNativeQuery(name="Sales.getSalesReport", query="SELECT salesperson_id as salesperson_id,'' as salesperson_name, sum(commision) as commision, count(commision) as number_of_sales, :quarter as quarter FROM sales s where s.sales_date >= :start_date and s.sales_date <= :end_date group by s.salesperson_id", resultSetMapping="SalesReportMapping")

public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sales_id;
	
	@Column(name = "product_id")
	private long product_id;
	
	@Column(name = "customer_id")
	private long customer_id;
	
	@Column(name = "salesperson_id")
	private long salesperson_id;
	
	@Column(name = "commision")
	private float commision;
	
	@Column(name = "sales_date")
	private Date sales_date;
	
	@ManyToOne
	@JoinColumn(name = "product_id",insertable=false, updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "customer_id",insertable=false, updatable=false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "salesperson_id",insertable=false, updatable=false)
	private Salesperson salesperson;

	public Sales() {
		
	}

	public Sales(long product_id, long customer_id, long salesperson_id, float commision,
			Date sales_date) {
		
		super();
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.salesperson_id = salesperson_id;
		this.commision = commision;
		this.sales_date = sales_date;
		
	}

	public long getSales_id() {
		return sales_id;
	}

	public void setSales_id(long sales_id) {
		this.sales_id = sales_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getSalesperson_id() {
		return salesperson_id;
	}

	public void setSalesperson_id(long salesperson_id) {
		this.salesperson_id = salesperson_id;
	}

	public float getCommision() {
		return commision;
	}

	public void setCommision(float commision) {
		this.commision = commision;
	}

	public Date getSales_date() {
		return sales_date;
	}

	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}

	@Override
	public String toString() {
		return "Sales [sales_id=" + sales_id + ", product_id=" + product_id + ", customer_id=" + customer_id
				+ ", salesperson_id=" + salesperson_id + ", commision=" + commision + ", sales_date=" + sales_date
				+ "]";
	}
	
	
	

}
