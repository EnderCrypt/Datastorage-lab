package se.github.datalab.service;

import java.util.ArrayList;
import java.util.List;

import se.github.datalab.model.Order;
import se.github.datalab.model.Product;
import se.github.datalab.model.User;
import se.github.datalab.repository.OrderRepository;
import se.github.datalab.repository.ProductRepository;
import se.github.datalab.repository.UserRepository;
import se.github.datalab.statuses.OrderStatus;
import se.github.datalab.statuses.ProductStatus;
import se.github.datalab.statuses.UserStatus;

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
		public User add(User user)
		{
			return userRepo.update(user);
		}

		public User getBy(Long id)
		{
			return userRepo.getById(id);
		}

		public List<User> getAll()
		{
			return new ArrayList<>(userRepo.getAll());
		}

		public User getBy(String username)
		{
			return userRepo.getByUsername(username);
		}

		public void changeStatus(User user, UserStatus status)
		{
			user.setUserStatus(status);
			userRepo.update(user);
		}
	}

	public class OrderCategory // -------------ORDER---------
	{

		public Order add(Order order)
		{
			if (order.getProductIds().isEmpty())
			{
				throw new IllegalArgumentException("Cannot add empty order");
			}
			return orderRepo.update(order);
		}

		public Order getBy(Long id)
		{
			return orderRepo.getById(id);
		}

		public List<Order> getAll()
		{
			return new ArrayList<>(orderRepo.getAll());
		}

		public List<Order> getBy(User user)
		{
			List<Order> allOrders = new ArrayList<>();
			for (Long id : user.getOrderIds())
			{
				allOrders.add(orderRepo.getById(id));
			}
			return new ArrayList<>(allOrders);
		}

		public List<Order> getBy(OrderStatus status)
		{
			return new ArrayList<>(orderRepo.getByStatus(status));
		}

		public List<Order> getBy(double price)
		{
			return new ArrayList<>(orderRepo.getByMinCost(price));
		}

		public void changeStatus(Order order, OrderStatus status)
		{
			order.setOrderStatus(status);
			orderRepo.update(order);
		}
	}

	public class ProductCategory // ------------PRODUCT------------
	{
		public Product add(Product product)
		{
			return prodRepo.update(product);
		}

		public Product getBy(Long id)
		{
			return prodRepo.getById(id);
		}

		public List<Product> getAll()
		{
			return new ArrayList<>(prodRepo.getAll());
		}

		public List<Product> getBy(String name)
		{
			return new ArrayList<>(prodRepo.getProduct(name.toLowerCase()));
		}

		public void changeStatus(Product product, ProductStatus status)
		{
			product.setProductStatus(status);
			prodRepo.update(product);
		}
	}
}
