package navbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import navbar.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	void updateByName(String name);

	void updateByPrice(Float price);

	void updateByName(Product product);

}
