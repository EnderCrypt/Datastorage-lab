package se.github.datalab.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import se.github.datalab.statuses.OrderStatus;

@NamedQueries(value = {
		@NamedQuery(name = "Orders.GetAll", query = "SELECT o FROM Order o"),
		@NamedQuery(name = "Orders.GetOrderByStatus", query = "SELECT o FROM Order o WHERE o.orderStatus = :status"),
		@NamedQuery(name = "Orders.GetOrderByMinCost", query = "SELECT o FROM Order o WHERE o.orderCost >= :cost")
})
@Entity
@Table(name = "Orders")
public class Order extends Id
{
	// @Column(nullable = false)
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Product> products;

	private double orderCost;

	@Column(name = "order_status", nullable = false)
	private int orderStatus;

	public Order()
	{
		products = new ArrayList<>();
	}

	public OrderStatus getOrderStatus()
	{
		return OrderStatus.values()[orderStatus];
	}

	public void setOrderStatus(OrderStatus status)
	{
		this.orderStatus = status.ordinal();
	}

	public Collection<Product> getProducts()
	{
		return new ArrayList<>(products);
	}

	public Order addProduct(Product product)
	{
		products.add(product);
		orderCost += product.getPrice();
		return this;
	}

	public double getOrderCost()
	{
		return orderCost;
	}

	@Override
	public String toString()
	{
		return id + ":" + products.toString() + ":" + orderCost + ":" + orderStatus;
	}

}
