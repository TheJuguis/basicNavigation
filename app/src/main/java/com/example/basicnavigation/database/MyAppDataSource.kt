package com.example.basicnavigation.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.room.Entity
import androidx.room.PrimaryKey

class MyAppDataSource (private val userDao: UserDao){
    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUsersFromDatabase().map { it.toUser() })
    }

    suspend fun getSingleUser(query:String): LiveData<User> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUserByUserName(query).toUser())
    }

    suspend fun delete(user: User) = withContext(Dispatchers.IO){
        userDao.delete(user.toEntity())
    }

    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }
}