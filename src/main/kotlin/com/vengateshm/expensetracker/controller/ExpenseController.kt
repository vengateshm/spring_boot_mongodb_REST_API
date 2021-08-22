package com.vengateshm.expensetracker.controller

import com.vengateshm.expensetracker.dto.ExpenseDto
import com.vengateshm.expensetracker.response.ExpenseResponse
import com.vengateshm.expensetracker.service.ExpenseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/expense")
@CrossOrigin("*")
class ExpenseController(private val expenseService: ExpenseService) {
    @GetMapping("/all")
    fun getAll(): ResponseEntity<ExpenseResponse> {
        val expenses = expenseService.getAll()
        return ResponseEntity(ExpenseResponse().apply {
            this.status = true
            this.expenses = expenses
        }, HttpStatus.OK)
    }

    @PostMapping
    fun create(@RequestBody expenseDto: ExpenseDto): ResponseEntity<Any> {
        expenseService.create(expenseDto)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/all")
    fun deleteAll(): ResponseEntity<Any> {
        expenseService.deleteAll()
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Any> {
        expenseService.deleteById(id)
        return ResponseEntity(HttpStatus.OK)
    }
}