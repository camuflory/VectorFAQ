package com.norameyer.vectorfaq.data

import android.app.Application

class App : Application() {
    val database by lazy { MainDB.createDatabase(this) }
}