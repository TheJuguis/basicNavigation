package com.example.basicnavigation

import android.app.Application
import com.example.basicnavigation.database.DataBaseManager

open class MyAplication : Application(){
    override fun onCreate() {
        DataBaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}