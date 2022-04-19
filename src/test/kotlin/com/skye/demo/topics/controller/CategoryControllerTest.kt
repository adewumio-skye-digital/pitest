package com.skye.demo.topics.controller

import com.skye.demo.topics.model.Category
import com.skye.demo.topics.service.CategoryService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@WebMvcTest
internal class CategoryControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockBean
    lateinit var service: CategoryService

    @Test
    fun `Should return 200 when all categories found`() {
        var cat = Category(2L, "Hello", "Helloooos")
        `when`(service.all()).thenReturn(Arrays.asList(cat))
        mockMvc.perform(get("/categories"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `Get service should return the correct service instance`() {
        var serv = CategoryController(service).service;
        assertThat(serv).isEqualTo(service)
    }
}
