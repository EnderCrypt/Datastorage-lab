package se.github.datalab.repository.jpastorage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.Id;
import se.github.datalab.repository.StorageRepository;

public abstract class JpaAbstractRepository<E extends Id> implements StorageRepository<E>
{
	protected EntityManagerFactory factory;
	protected Class<E> entityClass;

	public JpaAbstractRepository(EntityManagerFactory factory, Class<E> entityClass)
	{
		this.factory = factory;
		this.entityClass = entityClass;
	}

	@Override
	public E update(E entity)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			if (entity.hasId())
			{
				return manager.merge(entity);
			}
			manager.persist(entity);
			manager.getTransaction().commit();
			return entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			manager.close();
		}
		return entity;

	}

	@Override
	public E remove(E entity)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
			manager.getTransaction().commit();
			return entity;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			manager.close();
		}
		return null;
	}

	@Override
	public E getById(Long id)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			return manager.find(entityClass, id);
		}
		catch (Exception e)
		{
			throw new RuntimeException();
		}
		finally
		{
			manager.close();
		}
	}

	public List<E> query(String queryName, Class<E> entityClass)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			TypedQuery<E> query = manager.createNamedQuery(queryName, entityClass);
			List<E> result = query.getResultList();
			manager.getTransaction().commit();
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			manager.close();
		}
		return null;

	}

}
