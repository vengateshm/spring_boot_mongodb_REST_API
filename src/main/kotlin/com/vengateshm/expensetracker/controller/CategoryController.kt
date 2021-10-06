package com.vengateshm.expensetracker.controller

import com.vengateshm.expensetracker.dto.CategoryDto
import com.vengateshm.expensetracker.response.CategoryResponse
import com.vengateshm.expensetracker.service.CategoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("*")
@Api(value = "Category Controller", tags = ["Category resource RESTful services"])
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping("/all")
    @ApiOperation(value = "Retrieve all categories")
    fun getAll(): ResponseEntity<CategoryResponse> {
        val categories = categoryService.getAll()
        return ResponseEntity(CategoryResponse().apply {
            this.status = true
            this.categories = categories
        }, HttpStatus.OK)
    }

    @PostMapping
    fun create(
        @ApiParam("New category to be created")
        @RequestBody categoryDto: CategoryDto
    ): ResponseEntity<Any> {
        categoryService.create(categoryDto)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/all")
    fun deleteAll(): ResponseEntity<Any> {
        categoryService.deleteAll()
        return ResponseEntity(HttpStatus.OK)
    }
}