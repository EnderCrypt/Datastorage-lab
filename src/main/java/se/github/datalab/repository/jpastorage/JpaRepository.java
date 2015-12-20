package se.github.datalab.repository.jpastorage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import se.github.datalab.model.Id;
import se.github.datalab.repository.StorageRepository;

public class JpaRepository<E extends Id> implements StorageRepository<E>
{
	private EntityManagerFactory factory;
	
	public JpaRepository(EntityManagerFactory factory)
	{
		this.factory = factory;
	}
	
	@Override
	public E update(E entity)
	{
		EntityManager manager = factory.createEntityManager();
		if(entity.getId() == null)
		{
			manager.persist(entity);
		}
		manager.merge(entity);
		return entity;
	}

	@Override
	public E remove(E entity)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getById(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
