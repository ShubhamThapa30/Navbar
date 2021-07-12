package navbar.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import navbar.Services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping("/categories")
	public List<Category> list() {
		return service.listAll();
	}

	@GetMapping("categories/{id}")
	public ResponseEntity<Category> get(@PathVariable Integer id) {
		try {
			Category category = service.get(id);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/categories")
	public void add(@RequestBody Category category) {
		service.save(category);
	}

	@PutMapping("categories/{id}")
	public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Integer id) {
		try {
			service.get(id);
			service.save(category);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/category/categories/parent_id")
	public void SaveByCategories(@RequestBody Category category) {
		service.save(category);
	}
}
