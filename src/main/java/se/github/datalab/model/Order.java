package se.github.datalab.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	@ManyToMany
	private Collection<Product> products;

	private double orderCost;

	@Column(name = "order_status", nullable = false)
	private int orderStatus;

	public Order()
	{
		products = new HashSet<>();
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
		return new HashSet<>(products);
	}

	public Order addProduct(Product product)
	{
		products.add(product);
		return this;
	}

	public double getOrderCost()
	{
		return orderCost;
	}

}
