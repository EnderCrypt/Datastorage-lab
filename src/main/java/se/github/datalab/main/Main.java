package se.github.datalab.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.github.datalab.repository.UserRepository;
import se.github.datalab.repository.jpastorage.JpaUserRepository;

public class Main
{
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args)
	{
		UserRepository userRepo = new JpaUserRepository(factory);
		//		StorageRepository<Product> productRepo = new JpaAbstractRepository<>(factory);
		//		StorageRepository<Order> orderRepo = new JpaAbstractRepository<>(factory);
		//		ECommerceService eCom = new ECommerceService(userRepo, null, null);
		//		eCom.order.getAll();
		//		Order o = new Order();
		//		o.setOrderStatus(OrderStatus.CANCELLED);

	}
}
