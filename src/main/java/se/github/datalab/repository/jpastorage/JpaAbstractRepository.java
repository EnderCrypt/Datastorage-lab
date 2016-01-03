package se.github.datalab.repository.jpastorage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
		if (entity.hasId())
		{
			manager.merge(entity);
			manager.close();
			return entity;
		}
		manager.persist(entity);
		manager.close();
		return entity;

	}

	@Override
	public E remove(E entity)
	{
		EntityManager manager = factory.createEntityManager();
		manager.remove(entity);
		manager.close();
		return entity;
	}

	@Override
	public E getById(Long id)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			return manager.find(entityClass, id);
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
