package com.ggr3ml1n.dailyplanner.mainviewmodel

import androidx.lifecycle.*
import com.ggr3ml1n.dailyplanner.database.MainDatabase
import com.ggr3ml1n.dailyplanner.entities.Plan
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(database: MainDatabase) : ViewModel() {
    
    val dao = database.getDao()
    val allPlans: LiveData<List<Plan>> = dao.getAllPlans().asLiveData()
    
    fun insertPlan(plan: Plan) = viewModelScope.launch {
        dao.insertPlan(plan)
    }
    
    class MainViewModelFactory(val database: MainDatabase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}