package com.skye.demo.topics.service

import com.skye.demo.topics.data.CategoryRepository
import com.skye.demo.topics.model.Category
import org.springframework.stereotype.Service

@Service
class CategoryService(val repository: CategoryRepository) {

    fun all(): List<Category> = repository.findAll();
}
