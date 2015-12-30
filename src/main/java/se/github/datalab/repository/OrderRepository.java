package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.Order;
import se.github.datalab.statuses.OrderStatus;

public interface OrderRepository extends StorageRepository<Order>
{
	Collection<Order> getAll();

	Order getByStatus(OrderStatus status);
}
