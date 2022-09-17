package com.example.demo.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.UserRepository.ProductsRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Products;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository prepo;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService cService;
	
	
	public Products addProduct(ProductDto productD) {
		
		Products product=new Products();
		
		product.setImagePath(productD.getImagePath());
		product.setProductDescription(productD.getProductDescription());
product.setProductName(productD.getProductName());
product.setProductPrce(productD.getProductPrce());
product.setProductQuantity(productD.getProductQuantity());
		product.setUserpro(userService.findById(productD.getUserId()));
		product.setCategory(cService.findById(productD.getCategoryId()));
		
		return prepo.save(product);
	}

	public List<Products> getAllPro() {
		
		
		return prepo.findAll();
	}


	public Products fetchProductsById(int id) {
		
		Optional<Products> pro=prepo.findById(id);
		
		return pro.get();
	}

	public void deleteProductsById(Integer productId) {

		prepo.deleteById(productId);
	}



	public Products getProductsByName(String productName) {
		
		return prepo.findByProductName(productName);
	}

	public Products updateProduct(int id, ProductDto pDto) {
		// TODO Auto-generated method stub
	 Optional<Products>upProduct=prepo.findById(id);
	 
	 Products products=upProduct.get();
	 products.setProductName(pDto.getProductName());
	 products.setProductDescription(pDto.getProductDescription());
	 products.setImagePath(pDto.getImagePath());
	 products.setProductQuantity(pDto.getProductQuantity());
	 products.setProductPrce(pDto.getProductPrce());
	 return prepo.save(products);
	}
}
 




