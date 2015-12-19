package se.github.datalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends Id
{
	@Column(nullable = false)
	private String name;
	private String description;
	private double price;
	private String productStatus;
	protected Product()
	{}
	public Product(String name, String description, double price)
	{
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public String getName()
	{
		return name;
	}
	public String getProductStatus()
	{
		return productStatus;
	}
	public void setProductStatus(String productStatus)
	{
		this.productStatus = productStatus;
	}
}
