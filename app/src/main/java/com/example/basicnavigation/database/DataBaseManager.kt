package com.example.basicnavigation.database

import android.content.Context
import androidx.room.Room
import java.security.AccessControlContext
import androidx.room.Entity
import androidx.room.PrimaryKey

class DataBaseManager {
    lateinit var database: AppDatabase

    companion object{
        val instance = DataBaseManager()
    }

    fun initializeDb(context: Context){
        createDb(context)
    }

    private fun createDb(context: Context){
        database = Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}