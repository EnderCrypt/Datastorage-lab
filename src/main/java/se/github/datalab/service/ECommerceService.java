package se.github.datalab.service;

import java.util.List;

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

	// public final OrderCategory order = new OrderCategory();

	// TODO: make eCommerce take in unlimited amount of repositories
	// TODO: Check doc file to see which methods/operations eCom needs to have
	// toward the database
	public ECommerceService(UserRepository userRepo, ProductRepository prodRepo, OrderRepository orderRepo)
	{
		this.userRepo = userRepo;
		this.prodRepo = prodRepo;
		this.orderRepo = orderRepo;
	}

	// ----------- USER---------

	public void addUser(User user)
	{
	}

	public List<User> getAllUsers(User user)
	{
		// return new ArrayList<>(userRepo.getAll);
		return null;
	}

	public User getUserById(Long id)
	{
		return userRepo.getById(id);
	}

	public User getUsername(String username)
	{
		return null;
	}

	public User createUser(User user)
	{
		return null;
	}

	public User updateUser(User user)
	{
		return null;
	}

	public User changeUserStatus(User user)
	{
		return null;
	}

	// -------------ORDER---------

	public void addOrder(Order order)
	{
	}

	public Order getOrderById(Long id)
	{
		return orderRepo.getById(id);
	}

	public List<Order> getAllOrders(Order order)
	{
		return null;
	}

	public List<Order> getAllOrderByUsername(User user)
	{
		return null;
	}

	// ------------PRODUCT------------
	public void addProduct(Product product)
	{
	}

	public Product getProductById(Product product)
	{
		return null;
	}

	public Product getAllProducts(Product product)
	{
		return null;
	}

	public Product getProductName(Product product)
	{
		return null;
	}

	public Product updateProduct(Product product)
	{
		return null;
	}

	public Product changeProductStatus(Product product)
	{
		return null;
	}
}
