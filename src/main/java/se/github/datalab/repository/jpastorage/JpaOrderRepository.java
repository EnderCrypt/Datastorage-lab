package se.github.datalab.repository.jpastorage;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.Order;
import se.github.datalab.repository.OrderRepository;
import se.github.datalab.statuses.OrderStatus;

public class JpaOrderRepository extends JpaAbstractRepository<Order> implements OrderRepository
{

	public JpaOrderRepository(EntityManagerFactory factory)
	{
		super(factory, Order.class);
	}

	@Override
	public Collection<Order> getAll()
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		try
		{
			TypedQuery<Order> result = manager.createNamedQuery("Orders.GetAll", Order.class);
			return result.getResultList();
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			manager.getTransaction().commit();
			manager.close();
		}
	}

	@Override
	public List<Order> getByStatus(OrderStatus status)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		try
		{
			TypedQuery<Order> result = manager.createNamedQuery("Orders.GetOrderByStatus", Order.class);
			result.setParameter("status", status.ordinal());
			return result.getResultList();
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			manager.getTransaction().commit();
			manager.close();
		}
	}

	@Override
	public Collection<Order> getByMinCost(double price)
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		try
		{
			TypedQuery<Order> result = manager.createNamedQuery("Orders.GetOrderByMinCost", Order.class);
			result.setParameter("cost", price);
			return result.getResultList();
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			manager.getTransaction().commit();
			manager.close();
		}
	}

}
