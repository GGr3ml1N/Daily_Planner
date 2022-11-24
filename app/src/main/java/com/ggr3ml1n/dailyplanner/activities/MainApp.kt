package com.ggr3ml1n.dailyplanner.activities

import android.app.Application
import com.ggr3ml1n.dailyplanner.database.MainDatabase

class MainApp : Application() {
    val database by lazy { MainDatabase.getDatabase(this) }
}