package com.example.basicnavigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicnavigation.database.DataBaseManager
import com.example.basicnavigation.database.MyAppDataSource
import com.example.basicnavigation.database.User
import kotlinx.coroutines.launch

class LeftViewModel : ViewModel(){
    fun save(user : User){
    viewModelScope.launch {
        val userDao = DataBaseManager.instance.database.userDao()
        MyAppDataSource(userDao).save(user)
    }
    }
}