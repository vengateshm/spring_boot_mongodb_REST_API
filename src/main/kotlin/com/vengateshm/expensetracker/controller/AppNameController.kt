package com.vengateshm.expensetracker.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class AppNameController {
    @GetMapping(produces = [MediaType.TEXT_HTML_VALUE])
    fun appName(): String {
        return """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ExpenseTracker</title>
</head>
<body>
<h3>Expense Tracker App</h3>
<h5>v1.0.0</h5>
</body>
</html>""";
    }
}