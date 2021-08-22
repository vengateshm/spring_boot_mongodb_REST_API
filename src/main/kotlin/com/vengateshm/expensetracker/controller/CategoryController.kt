package com.vengateshm.expensetracker.controller

import com.vengateshm.expensetracker.dto.CategoryDto
import com.vengateshm.expensetracker.response.CategoryResponse
import com.vengateshm.expensetracker.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("*")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping("/all")
    fun getAll(): ResponseEntity<CategoryResponse> {
        val categories = categoryService.getAll()
        return ResponseEntity(CategoryResponse().apply {
            this.status = true
            this.categories = categories
        }, HttpStatus.OK)
    }

    @PostMapping
    fun create(@RequestBody categoryDto: CategoryDto): ResponseEntity<Any> {
        categoryService.create(categoryDto)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/all")
    fun deleteAll(): ResponseEntity<Any> {
        categoryService.deleteAll()
        return ResponseEntity(HttpStatus.OK)
    }
}