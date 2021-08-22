package com.vengateshm.expensetracker.service

import com.vengateshm.expensetracker.dto.ExpenseDto
import com.vengateshm.expensetracker.model.Expense
import com.vengateshm.expensetracker.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseServiceImpl(private val expenseRepository: ExpenseRepository) : ExpenseService {
    override fun create(expenseDto: ExpenseDto) {
        Expense(
            categoryId = expenseDto.categoryId,
            description = expenseDto.description,
            amount = expenseDto.amount,
            dateAdded = expenseDto.dateAdded
        ).also {
            expenseRepository.save(it)
        }
    }

    override fun getAll(): List<ExpenseDto> {
        return expenseRepository.findAll().map { expense ->
            ExpenseDto(expense.expenseId, expense.categoryId, expense.description, expense.amount, expense.dateAdded)
        }
    }

    override fun deleteAll() {
        expenseRepository.deleteAll()
    }

    override fun deleteById(id: String) {
        expenseRepository.deleteById(id)
    }
}