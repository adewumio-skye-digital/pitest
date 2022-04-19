package com.skye.demo.topics.controller

import com.skye.demo.topics.model.Category
import com.skye.demo.topics.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(val service: CategoryService) {

    @GetMapping("/categories")
    fun retrieveAllCategories(): List<Category> = service.all();
}
