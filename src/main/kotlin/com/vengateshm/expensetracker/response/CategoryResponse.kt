package com.vengateshm.expensetracker.response

import com.vengateshm.expensetracker.dto.CategoryDto

class CategoryResponse : BaseResponse() {
    var categories: List<CategoryDto> = emptyList()
}