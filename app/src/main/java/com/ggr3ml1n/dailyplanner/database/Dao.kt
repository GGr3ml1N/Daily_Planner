package com.ggr3ml1n.dailyplanner.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ggr3ml1n.dailyplanner.entities.Plan
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    
    @Insert
    suspend fun insertPlan(plan: Plan)
    
    @Query("SELECT * FROM plans_list")
    fun getAllPlans(): Flow<List<Plan>>
    
}