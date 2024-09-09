package com.norameyer.vectorfaq.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(qaEntity: QAEntity)

    @Delete
    suspend fun deleteItem(qaEntity: QAEntity)

    @Query("SELECT * FROM qa")
    fun getAllQA() : Flow<List<QAEntity>>
}