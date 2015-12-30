package se.github.datalab.repository.jpastorage;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.Product;
import se.github.datalab.repository.ProductRepository;

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

}
