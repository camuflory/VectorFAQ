package com.norameyer.vectorfaq.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QAEntity::class], version = 2)
abstract class MainDB : RoomDatabase() {

    abstract val dao: Dao

    companion object {
        fun createDatabase(context: Context) : MainDB {
            return Room.databaseBuilder(context, MainDB::class.java, "database.db").build()
        }
    }

}