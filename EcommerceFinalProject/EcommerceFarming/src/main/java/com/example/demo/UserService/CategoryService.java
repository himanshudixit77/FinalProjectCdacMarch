package com.example.demo.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.UserRepository.CategoryRepository;
import com.example.demo.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> listCategory() {
		return categoryRepo.findAll();
	}
	
	public  Category  findByName(String name) {
		return categoryRepo.findByCategoryName(name);
	}
	public Category findById(int id) {
		return categoryRepo.findById(id).get();
	}
    
	
	public Optional<Category> getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(categoryId);
	}
}
