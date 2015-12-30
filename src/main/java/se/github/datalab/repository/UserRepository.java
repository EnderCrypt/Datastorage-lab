package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.User;

public interface UserRepository extends StorageRepository<User>
{
	Collection<User> getAll();
	User getUserByEmail(String email);
}
