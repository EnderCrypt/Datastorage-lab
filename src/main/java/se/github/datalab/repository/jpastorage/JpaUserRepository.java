package se.github.datalab.repository.jpastorage;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import se.github.datalab.model.User;
import se.github.datalab.repository.UserRepository;

public class JpaUserRepository extends JpaAbstractRepository<User>implements UserRepository
{

	public JpaUserRepository(EntityManagerFactory factory)
	{
		super(factory, User.class);
	}

	@Override
	public Collection<User> getAll()
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<User> result = manager.createNamedQuery("User.GetAll", User.class);
			return result.getResultList();
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
	public User getUserByEmail(String email)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<User> result = manager.createNamedQuery("User.GetUserByEmail", User.class);
			result.setParameter("email", email);
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
	public User getUsername(String username)
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			TypedQuery<User> result = manager.createNamedQuery("User.GetUserByUsername", User.class);
			result.setParameter("username", username);
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

}
