package se.github.datalab.service;

import java.util.HashSet;
import java.util.Set;

import se.github.datalab.model.Order;
import se.github.datalab.model.Product;
import se.github.datalab.model.User;
import se.github.datalab.repository.OrderRepository;
import se.github.datalab.repository.ProductRepository;
import se.github.datalab.repository.UserRepository;

public class ECommerceService
{
	private UserRepository userRepo;
	private ProductRepository prodRepo;
	private OrderRepository orderRepo;

	public final OrderCategory order = new OrderCategory();

	// TODO: make eCommerce take in unlimited amount of repositories
	//TODO: Check doc file to see which methods/operations eCom needs to have toward the database
	public ECommerceService(UserRepository userRepo, ProductRepository prodRepo, OrderRepository orderRepo)
	{
		this.userRepo = userRepo;
		this.prodRepo = prodRepo;
		this.orderRepo = orderRepo;
	}

	public void addUser(User user)
	{
		userRepo.update(user);
	}

	public void addOrder(Order order)
	{
	}

	public void addProduct(Product product)
	{

	}

	public Product getById(Long id)
	{
		return prodRepo.getById(id);
	}

	public Set<User> getAllUsers()
	{
		return new HashSet<>(userRepo.getAll());
	}

	//TODO: categorize each operation/method to its respective category
	public class OrderCategory
	{

	}

}
