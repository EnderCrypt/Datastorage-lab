package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.Product;
import se.github.datalab.statuses.ProductStatus;

public interface ProductRepository extends StorageRepository<Product>
{
	Collection<Product> getAll();

	Collection<Product> getProduct(String name);

	Collection<Product> getProductByStatus(ProductStatus status);

	Collection<Product> getProductByCost(double price);

}
