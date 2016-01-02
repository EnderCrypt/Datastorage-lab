package se.github.datalab.repository;

import java.util.Collection;

import javax.persistence.Id;

import se.github.datalab.model.User;
import se.github.datalab.statuses.UserStatus;

public interface UserRepository extends StorageRepository<User>
{
	Collection<User> getAll();

	User getUserByEmail(String email);

	User getByUsername(String username);

	User getUserById(Id id);

	User getUserByStatus(UserStatus status);
}
