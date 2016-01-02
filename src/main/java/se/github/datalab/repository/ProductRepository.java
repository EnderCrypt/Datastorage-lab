package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.Id;
import se.github.datalab.model.Product;
import se.github.datalab.statuses.ProductStatus;

public interface ProductRepository extends StorageRepository<Product>
{
	Collection<Product> getAll();

	Product getProductById(Id id);

	Product getProduct(String name);

	Product getProductByStatus(ProductStatus status);

	Product getProductByCost(double price);

}
