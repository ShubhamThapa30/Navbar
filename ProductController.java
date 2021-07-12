package navbar.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import navbar.Entity.Product;
import navbar.Services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	@GetMapping("products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		service.save(product);
	}

	@PutMapping("products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			service.get(id);
			service.save(product);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/products/{name}")
	public void update(@RequestBody Product product) {
		service.update(product);
	}

	@PostMapping("/products/{price}")
	public void updateByPrice(@RequestBody Product product) {
		service.update(product);
	}

	@PostMapping("/category/categories/{id}")
	public void SaveByCategories(@RequestBody Product product) {
		service.save(product);
	}

	@GetMapping("/category/{id}")
	public void SaveByCategory(@RequestBody Product product) {
		service.save(product);
	}
}