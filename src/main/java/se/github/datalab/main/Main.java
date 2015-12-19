package se.github.datalab.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.github.datalab.model.Order;
import se.github.datalab.model.Product;
import se.github.datalab.model.User;
import se.github.datalab.repository.StorageRepository;
import se.github.datalab.repository.jpastorage.JpaRepository;
import se.github.datalab.service.ECommerceService;

public class Main
{
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
	
	public static void main(String[] args)
	{
		StorageRepository<User> userRepo = new JpaRepository<>(factory);
		StorageRepository<Product> productRepo = new JpaRepository<>(factory);
		StorageRepository<Order> orderRepo = new JpaRepository<>(factory);
		ECommerceService eCom = new ECommerceService(userRepo, productRepo, orderRepo);
		
		
//		eCom.addUser(new User());
//		eCom.addProduct(new Product());
//		eCom.addOrder(new Order());
		
//		System.out.println(factory.isOpen());
//		factory.close();
//		System.out.println(factory.isOpen());
		
	}
}
