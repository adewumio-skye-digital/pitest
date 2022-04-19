package com.skye.demo.topics.service

import com.skye.demo.topics.data.CategoryRepository
import com.skye.demo.topics.model.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.*

internal class CategoryServiceTest {

    @Mock
    lateinit var repository: CategoryRepository
    lateinit var service: CategoryService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        service = CategoryService(repository)
    }

    @Test
    fun `Return all categories when repository returns non empty list`() {
        var cat = Category(1L, "Test", "Hello")
        given(repository.findAll()).willReturn(Collections.singletonList(cat))
        var list: List<Category> = service.all();
        then(repository).should(atMostOnce()).findAll()
        assertThat(list.get(0)).isEqualTo(cat)
    }


    @Test
    fun `Return empty categories when repository returns empty list`() {
        given(repository.findAll()).willReturn(Collections.emptyList())
        var list: List<Category> = service.all()
        then(repository).should(atMostOnce()).findAll()
        assertThat(list.isEmpty())
    }

    @Test
    fun `Returns repository bean when get repository is called`() {
        var repo: CategoryRepository = service.repository;
        assertThat(repo).isEqualTo(service.repository)
    }
}
