package navbar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import navbar.Entity.Product;
import navbar.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public java.util.List<Product> listAll() {
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(Integer id) {
		return repo.findById(id).get();
	}

	public void update(Product product) {
		repo.updateByName(product);
	}

	public void update(Float price) {
		repo.updateByPrice(price);
	}

	public void SaveByCategories(Product product) {
		repo.save(product);
	}

	public void SaveByCategory(Product product) {
		repo.save(product);
	}
}
