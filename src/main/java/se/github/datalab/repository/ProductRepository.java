package se.github.datalab.repository;

import java.util.Collection;

import se.github.datalab.model.Product;

public interface ProductRepository extends StorageRepository<Product>
{
	Collection<Product> getAll();
	Product getProduct(String name);
}
