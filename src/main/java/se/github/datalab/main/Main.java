package se.github.datalab.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.github.datalab.model.Order;
import se.github.datalab.model.Product;
import se.github.datalab.model.User;
import se.github.datalab.repository.OrderRepository;
import se.github.datalab.repository.ProductRepository;
import se.github.datalab.repository.UserRepository;
import se.github.datalab.repository.jpastorage.JpaOrderRepository;
import se.github.datalab.repository.jpastorage.JpaProductRepository;
import se.github.datalab.repository.jpastorage.JpaUserRepository;
import se.github.datalab.service.ECommerceService;

public class Main
{
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args)
	{
		UserRepository userRepo = new JpaUserRepository(factory);
		ProductRepository prodRepo = new JpaProductRepository(factory);
		OrderRepository orderRepo = new JpaOrderRepository(factory);
		ECommerceService eCom = new ECommerceService(userRepo, prodRepo, orderRepo);

		User user1 = new User("masterFranca", "secreto", "francis@anca.se");
		Product product1 = new Product("EverHard 2.0", "At times when life is neither hard or long", 99.9);
		Order order1 = new Order();

		order1.addProduct(product1);
		user1.addOrder(order1);

		eCom.user.add(user1);
		eCom.product.add(product1);
		eCom.order.add(order1);
	}
}
