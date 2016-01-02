package se.github.datalab.repository.jpastorage;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.Id;
import se.github.datalab.model.Product;
import se.github.datalab.repository.ProductRepository;
import se.github.datalab.statuses.ProductStatus;

public class JpaProductRepository extends JpaAbstractRepository<Product>implements ProductRepository
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
	public Product getProduct(String name)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProduct", Product.class);
			result.setParameter("name", name);
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

	@Override
	public Product getProductById(Id id)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.getProductById", Product.class);
			result.setParameter("id", id);
			return result.getResultList().get(0);
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException();
		}
		finally
		{
			manager.close();
		}
	}

	@Override
	public Product getProductByStatus(ProductStatus status)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProductByStatus", Product.class);
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

	@Override
	public Product getProductByCost(double price)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<Product> result = manager.createNamedQuery("Product.GetProductByCost", Product.class);
			result.setParameter("price", price);
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
