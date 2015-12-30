package se.github.datalab.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import se.github.datalab.statuses.OrderStatus;

@NamedQueries(value = {
		@NamedQuery(name = "Order.GetAll", query = "SELECT o FROM Order o"),
		@NamedQuery(name = "Order.GetOrderById", query = "SELECT o FROM Order o WHERE Id = :id"),
		@NamedQuery(name = "Order.GetOrderByStatus", query = "SELECT o FROM Order o WHERE orderStatus = ?status")
})
@Entity
@Table(name = "Orders")
public class Order extends Id
{
	// @Column(nullable = false)
	@ManyToMany(targetEntity = Product.class)
	private Collection<Long> productIds;

	private double orderCost;

	@Column(nullable = false)
	private int orderStatus;

	public Order()
	{
	}

	public OrderStatus getOrderStatus()
	{
		return OrderStatus.values()[orderStatus];
	}

	public void setOrderStatus(OrderStatus status)
	{
		this.orderStatus = status.ordinal();
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
