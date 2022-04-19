package com.skye.demo.topics.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Category(
    @Id
    val id: Long,
    val name:String,
    val description: String)
