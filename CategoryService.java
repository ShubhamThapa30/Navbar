package navbar.Services;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import navbar.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public java.util.List<Category> listAll() {
		return repo.findAll();
	}

	public void save(Category category) {
		repo.save(category);
	}

	public Category get(Integer id) {
		return repo.findById(id).get();
	}

	public void SaveByCategories(Category category) {
		repo.save(category);
	}
}
