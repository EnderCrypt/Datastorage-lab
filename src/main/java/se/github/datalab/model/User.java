package se.github.datalab.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import se.github.datalab.statuses.UserStatus;

@NamedQueries(value = {
		@NamedQuery(name = "User.GetAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.GetUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
		@NamedQuery(name = "User.GetUserByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
		@NamedQuery(name = "User.GetUserByStatus", query = "SELECT u FROM User u WHERE u.userStatus = :status")
})
@Entity
public class User extends Id
{
	@Column(nullable = false)
	private String username;
	private String password;
	@Column(nullable = false)
	private String email;
	@OneToMany
	private Collection<Order> orders;
	@Column(name = "user_status", nullable = false)
	private int userStatus;

	protected User()
	{
	}

	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		orders = new HashSet<>();
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

	public Collection<Order> getOrders()
	{
		return new HashSet<>(orders);
	}

	public User addOrder(Order order)
	{
		orders.add(order);
		return this;
	}

	public UserStatus getUserStatus()
	{
		return UserStatus.values()[userStatus];
	}

	public void setUserStatus(UserStatus userStatus)
	{
		this.userStatus = userStatus.ordinal();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (email == null)
		{
			if (other.email != null) return false;
		}
		else if (!email.equals(other.email)) return false;
		if (username == null)
		{
			if (other.username != null) return false;
		}
		else if (!username.equals(other.username)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		return id + ":" + username + ":" + email + ":" + userStatus;
	}
}
