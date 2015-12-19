package se.github.datalab.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class User extends Id
{
	@Column(nullable = false) 
	private String username;
	private String password;
	@Column(nullable = false) 
	private String email;
	@OneToMany(targetEntity=Order.class)
	private Collection<Long> orderIds;
	private String userStatus;
	protected User()
	{}
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getUsername()
	{
		return username;
	}
	public Collection<Long> getOrderIds()
	{
		return new HashSet<>(orderIds);
	}
	public User addOrder(Order order)
	{
		orderIds.add(order.getId());
		return this;
	}
	public String getUserStatus()
	{
		return userStatus;
	}
	public void setUserStatus(String userStatus)
	{
		this.userStatus = userStatus;
	}
}
