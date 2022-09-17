package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.CategoryService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Products;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	
	
	@PostMapping("/addcategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category c=categoryService.findByName(category.getCategoryName());
		if(c!=null)
			return ResponseEntity.status(HttpStatus.FOUND).build();
		else {
			
				Category cat= categoryService.addCategory(category);
				return ResponseEntity.ok(cat);
			}
		}
		
	
	
	@GetMapping("/list")
	 public ResponseEntity<List<Category>> getAllCategory(){
		 
		List<Category>pro=categoryService.listCategory();
		 if(pro.size()<=0) 
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build()	;	 
	 
	else
		return ResponseEntity.of(Optional.of(pro));}
	
	/*@GetMapping("/list")
	public  List<Category> listCategory() {
		return categoryService.listCategory();
	}*/
	
	@GetMapping("/getcategory/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id")int id) {
	 
		return categoryService.getCategory(id);
 }
	
	
}
