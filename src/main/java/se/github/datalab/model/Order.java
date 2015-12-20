package se.github.datalab.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries(value = {
			@NamedQuery(name = "Order.GetAll", query = "SELECT o FROM Order o"),
			@NamedQuery(name = "Order.GetOrderById", query = "SELECT o FROM Order o WHERE Id = ???"),
			//@NamedQuery(name = "Order.GetOrderFromUser", query = "SELECT o FROM Order o WHERE")
})
@Entity
@Table(name="Orders")
public class Order extends Id
{
//	@Column(nullable = false)
	@ManyToMany(targetEntity=Product.class)
	private Collection<Long> productIds;
	
	private double orderCost;
	
	@Column(nullable = false)
	private String orderStatus;
	protected Order(){}
	
	public String getOrderStatus()
	{
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	public Collection<Long> getProductIds()
	{
		return new ArrayList<>(productIds);
	}
	public Order addProduct(Product product)
	{
		productIds.add(product.getId());
		return this;
	}
	public double getOrderCost()
	{
		return orderCost;
	}
	
	
}
