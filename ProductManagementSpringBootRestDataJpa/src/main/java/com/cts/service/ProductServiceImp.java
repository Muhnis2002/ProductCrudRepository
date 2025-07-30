package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import  com.cts.exceptions.CatogoryNotFound;

import lombok.AllArgsConstructor;

@Service("service")
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
	
   
	ProductRepository repo;

//	@Autowired
//	public ProductServiceImp(ProductRepository repo) {
//		this.repo = repo;
//	}

	@Override
	public String addProduct(Product product) {

		 repo.save(product);
		 return "Product Saved successfully";
	}

	@Override
	public String updateProduct(Product product) {

		repo.save(product);
		return "Product Updated Successfully";
	}

	@Override
	public String deleteProductById(int productId) throws ProductNotFound {

		repo.delete(getProductById(productId));
		return "Product Deleted Successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {

		Optional<Product> optional=repo.findById(productId);
		if(optional.isEmpty())
		{
			throw new ProductNotFound("The given Product Id is not Found");
		}
		return optional.get();
	}

	@Override
	public List<Product> getAllProducts() {

		return repo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) throws CatogoryNotFound{
		List<Product> p1=repo.findByProductCategory(productCategory);
		if(p1.isEmpty())
		{
			throw new CatogoryNotFound("Catogory Not Found");
		}
		else
			return p1;

		
	}

	@Override
	public List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice) {

		return repo.findByProductPriceBetween(intialPrice, finalPrice);
	}

}
