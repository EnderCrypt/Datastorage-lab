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

	public final UserCategory user = new UserCategory();
	public final OrderCategory order = new OrderCategory();
	public final ProductCategory product = new ProductCategory();

	// TODO: Check doc file to see which methods/operations eCom needs to have
	// toward the database
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
			// TODO Auto-generated method stub
			return null;
		}

		public List<User> getAll()
		{
			// TODO Auto-generated method stub
			return null;
		}

		public User getByUsername(String username)
		{
			// TODO Auto-generated method stub
			return null;
		}

		public User update(User user)
		{
			// TODO Auto-generated method stub
			return null;
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
			// TODO Auto-generated method stub
			return null;
		}

		public List<Order> getByUser(User user)
		{
			// TODO Auto-generated method stub
			return null;
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

		public Product getById(Product product)
		{
			// TODO Auto-generated method stub
			return null;
		}

		public List<Product> getAll()
		{
			// TODO Auto-generated method stub
			return null;
		}

		public Product update(Product product)
		{
			// TODO Auto-generated method stub
			return null;
		}

		public void changeStatus(Product product)
		{
			// TODO Auto-generated method stub
		}
	}
}
