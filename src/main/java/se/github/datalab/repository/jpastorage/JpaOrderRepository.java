package se.github.datalab.repository.jpastorage;

import java.util.Collection;

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
		try
		{
			TypedQuery<Order> result = manager.createNamedQuery("Order.GetAll", Order.class);
			return result.getResultList();
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			manager.close();
		}
	}

	// eCom.getByStatus(OrderStatus.CANCELLED)
	@Override
	public Order getByStatus(OrderStatus status)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Order> result = manager.createNamedQuery("Order.GetOrderByStatus", Order.class);
			result.setParameter("status", status.ordinal());
			return result.getResultList().get(0);
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			manager.close();
		}
	}

}
