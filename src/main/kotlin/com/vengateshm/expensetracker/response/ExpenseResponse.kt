package com.vengateshm.expensetracker.response

import com.vengateshm.expensetracker.dto.ExpenseDto

class ExpenseResponse : BaseResponse() {
    var expenses: List<ExpenseDto> = emptyList()
}