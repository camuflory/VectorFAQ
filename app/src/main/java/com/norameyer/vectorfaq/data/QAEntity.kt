package com.norameyer.vectorfaq.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qa")
data class QAEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val question: String,
    val answer: String
)