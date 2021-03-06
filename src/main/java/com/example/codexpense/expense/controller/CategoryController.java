package com.example.codexpense.expense.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codexpense.expense.model.Category;
import com.example.codexpense.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	private CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
		
	}
	
	@GetMapping("/categories")
	Collection<Category> categories() {
		
		return categoryRepository.findAll();
	}
	
	//category/2
			@GetMapping("/category/{id}")
			ResponseEntity<?> getCategory(@PathVariable Long id){
			Optional<Category> category = categoryRepository.findById(id);
			 return category.map(response -> ResponseEntity.ok().body(response))
					 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
			 
			}
}
