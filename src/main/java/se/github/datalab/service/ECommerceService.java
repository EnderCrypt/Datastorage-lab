package se.github.datalab.service;

import se.github.datalab.model.Order;
import se.github.datalab.model.Product;
import se.github.datalab.model.User;
import se.github.datalab.repository.StorageRepository;

public class ECommerceService
{
	private StorageRepository<User> userRepo;
	private StorageRepository<Product> prodRepo;
	private StorageRepository<Order> orderRepo;
	public ECommerceService(StorageRepository<User> userRepo, StorageRepository<Product> prodRepo, StorageRepository<Order> orderRepo)
	{
		this.userRepo = userRepo;
		this.prodRepo = prodRepo;
		this.orderRepo = orderRepo;
	}
	
	public void addUser(User user)
	{}
	public void addOrder(Order order)
	{}
	public void addProduct(Product product)
	{}
	
	
}
