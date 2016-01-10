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
		//Instantiate local object variables
		UserRepository userRepo = new JpaUserRepository(factory);
		ProductRepository prodRepo = new JpaProductRepository(factory);
		OrderRepository orderRepo = new JpaOrderRepository(factory);
		ECommerceService eCom = new ECommerceService(userRepo, prodRepo, orderRepo);

		User user1 = new User("masterFranca", "secreto", "francis@anca.se");
		User user2 = new User("canSena", "dimenticato", "muhammed@sena.se");
		Product product1 = new Product("EverHard 2.0", "Use at times of masculine deficiency", 99.9);
		Product product2 = new Product("ShakeWeight", "Exceptional muscle building!", 149.95);
		Order order1 = new Order();

		//Persist initial entities into database
		eCom.product.add(product1);
		eCom.product.add(product2);

		//Assign arguments to internal collection of object
		order1.addProduct(product1);
		order1.addProduct(product2);
		user1.addOrder(order1);

		//Persist entities
		eCom.user.add(user1);
		eCom.user.add(user2);
		eCom.order.add(order1);

		//Update entity values in database
		eCom.user.changeStatus(user1, UserStatus.BANNED);
		eCom.user.changeStatus(user2, UserStatus.ADMIN);

		//Getters
		eCom.user.getBy(UserStatus.ADMIN).forEach(System.out::println);
		eCom.order.getBy(90).forEach(System.out::println);
		eCom.order.getBy(user1).forEach(System.out::println);
		eCom.product.getBy("hard").forEach(System.out::println);

	}
}
