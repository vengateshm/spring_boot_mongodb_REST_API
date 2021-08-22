package com.vengateshm.expensetracker.repository

import com.vengateshm.expensetracker.model.Expense
import org.springframework.data.mongodb.repository.MongoRepository

interface ExpenseRepository : MongoRepository<Expense, String> {
}