package se.github.datalab.service;

import java.util.ArrayList;
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

	public final UserCategory user = new UserCategory();
	public final OrderCategory order = new OrderCategory();
	public final ProductCategory product = new ProductCategory();

	// TODO: Check doc file to see which methods/operations eCom needs to have
	// toward the database
	//
	public ECommerceService(UserRepository userRepo, ProductRepository prodRepo, OrderRepository orderRepo)
	{
		this.userRepo = userRepo;
		this.prodRepo = prodRepo;
		this.orderRepo = orderRepo;
	}

	public class UserCategory// ----------- USER---------
	{
		public void add(User user)
		{
			// TODO Auto-generated method stub
		}

		public User getById(Long id)
		{
			return userRepo.getById(id);
		}

		public List<User> getAll()
		{
			return new ArrayList<>(userRepo.getAll());
		}

		public User getByUsername(String username)
		{
			return userRepo.getByUsername(username);
		}

		public User updateUser(User user)
		{
			return userRepo.update(user);
		}

		public void changeStatus(User user)
		{
			// TODO Auto-generated method stub
		}
	}

	public class OrderCategory // -------------ORDER---------
	{

		public void add(Order order)
		{
			// TODO Auto-generated method stub
		}

		public Order getById(Long id)
		{
			return orderRepo.getById(id);
		}

		public List<Order> getAll()
		{
			return new ArrayList<>(orderRepo.getAll());
		}

		public List<Order> getAllOrderFromUser(User user)
		{
			// TODO Auto-generated method stub
			return null;
		}

		public List<Order> getAllOrderFromStatus()
		{
			// TODO Auto-generated method stub
			return null;
		}

		public List<Order> getHighValueOrders(Order order)
		{
			if (order.getOrderCost() > 10000)
			{
				// return new ArrayList<>(orderRepo.getPremiumOrder);
			}
			return null;
		}

		public Order updateOrder(Order order)
		{
			return orderRepo.update(order);
		}

		public void changeStatus(Order order)
		{
			// TODO Auto-generated method stub
		}
	}

	public class ProductCategory // ------------PRODUCT------------
	{
		public void add(Product product)
		{
			// TODO Auto-generated method stub
		}

		public Product getById(Long id)
		{
			return prodRepo.getById(id);
		}

		public List<Product> getAll()
		{
			return new ArrayList<>(prodRepo.getAll());
		}

		public Product getProductName(String name)
		{
			return prodRepo.getProduct(name);
		}

		public Product updateProduct(Product product)
		{
			return prodRepo.update(product);
		}

		public void changeStatus(Product product)
		{
			// TODO Auto-generated method stub
		}
	}
}
