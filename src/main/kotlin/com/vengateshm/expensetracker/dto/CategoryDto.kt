package com.vengateshm.expensetracker.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "All details about category entity")
data class CategoryDto(
    val id: String?,
    @ApiModelProperty(
        notes = "Name should have at least 3 chars",
        required = true
    )
    val name: String
)
