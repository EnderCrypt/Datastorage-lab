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
import se.github.datalab.statuses.UserStatus;

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
		User user2 = new User("canSena", "dimenticato", "muhammed@cena.se");
		Product product1 = new Product("EverHard 2.0", "At times when life is neither hard or long", 99.9);
		Product product2 = new Product("ShakeWeight", "Exceptional muscle building!", 149.95);
		Order order1 = new Order();

		eCom.product.add(product1);
		eCom.product.add(product2);

		order1.addProduct(product1);
		order1.addProduct(product2);

		user1.addOrder(order1);

		eCom.order.add(order1);
		eCom.user.add(user1);
		eCom.user.add(user2);

		eCom.user.changeStatus(user1, UserStatus.BANNED);
		eCom.user.changeStatus(user2, UserStatus.ADMIN);

		eCom.user.getBy(UserStatus.ADMIN).forEach(System.out::println);
		eCom.order.getBy(90).forEach(System.out::println);

		//		eCom.user.assign(order1, user1);
		//		eCom.order.assign(product1, order1);

	}
}
