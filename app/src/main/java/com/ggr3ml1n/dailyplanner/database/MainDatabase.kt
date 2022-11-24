package com.ggr3ml1n.dailyplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ggr3ml1n.dailyplanner.entities.Plan


@Database(entities = [Plan::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    
    abstract fun getDao(): Dao
    
    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null
        fun getDatabase(context: Context): MainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "daily_planer.db",
                ).build()
                instance
            }
        }
    }
}