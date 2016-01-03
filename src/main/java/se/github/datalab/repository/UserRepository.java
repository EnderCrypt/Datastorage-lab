package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.User;
import se.github.datalab.statuses.UserStatus;

public interface UserRepository extends StorageRepository<User>
{
	Collection<User> getAll();

	Collection<User> getUserByStatus(UserStatus status);

	User getUserByEmail(String email);

	User getByUsername(String username);

}
