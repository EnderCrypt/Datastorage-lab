package se.github.datalab.repository.jpastorage;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.Product;
import se.github.datalab.repository.ProductRepository;
import se.github.datalab.statuses.ProductStatus;

public class JpaProductRepository extends JpaAbstractRepository<Product> implements ProductRepository
{

	public JpaProductRepository(EntityManagerFactory factory)
	{
		super(factory, Product.class);
	}

	@Override
	public Collection<Product> getAll()
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetAll", Product.class);
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

	@Override
	public List<Product> getProduct(String name)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProduct", Product.class);
			result.setParameter("name", name);
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

	@Override
	public List<Product> getProductByStatus(ProductStatus status)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProductByStatus", Product.class);
			result.setParameter("status", status.ordinal());
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

	@Override
	public List<Product> getProductByCost(double price)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProductByCost", Product.class);
			result.setParameter("price", price);
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

}
