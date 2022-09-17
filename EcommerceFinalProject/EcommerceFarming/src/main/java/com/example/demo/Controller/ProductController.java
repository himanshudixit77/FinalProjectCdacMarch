package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserRepository.CategoryRepository;
import com.example.demo.UserService.CategoryService;
import com.example.demo.UserService.ProductsService;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Products;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService proServ;

	@Autowired
	private CategoryRepository cRepository;

	@PostMapping("/addProducts")
	public ResponseEntity<Products> addProduct(@RequestBody ProductDto product) {

		try {

			Products pro = proServ.addProduct(product);
			return ResponseEntity.of(Optional.of(pro));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/allproducts")
	public List<Products> getAllProducts() {

		List<Products> pro = proServ.getAllPro();
		
		return pro;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Products> fetchProductsById(@PathVariable("id") Integer productId) {

		Products pro = proServ.fetchProductsById(productId);
		return ResponseEntity.ok(pro);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductsById(@PathVariable("id") Integer productId) {
		try {
			proServ.deleteProductsById(productId);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}



	@PutMapping("/update/{id}")                   //ni ho rha hai
	public ResponseEntity<Products> updateProduct(@PathVariable("id") int id, @RequestBody ProductDto pDto) {
		
		Products pro = proServ.updateProduct(id, pDto);
		return ResponseEntity.ok(pro);

	}
}
