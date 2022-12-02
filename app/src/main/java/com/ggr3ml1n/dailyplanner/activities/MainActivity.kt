package com.ggr3ml1n.dailyplanner.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ggr3ml1n.dailyplanner.R
import com.ggr3ml1n.dailyplanner.databinding.ActivityMainBinding
import com.ggr3ml1n.dailyplanner.fragments.CalendarFragment
import com.ggr3ml1n.dailyplanner.fragments.FragmentManager
import com.ggr3ml1n.dailyplanner.fragments.ListOfPlansFragment

class MainActivity : AppCompatActivity() {
    
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentOnStart()
        setBottomNavListener()
    }
    
    private fun setBottomNavListener(){
        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.btn_calendar -> {
                    FragmentManager.setFragment(CalendarFragment.newInstance(),this)
                }
                R.id.plan_list -> {
                    FragmentManager.setFragment(ListOfPlansFragment.newInstance(),this)
                }
            }
            true
        }
    }
    
    private fun fragmentOnStart(){
        FragmentManager.setFragment(CalendarFragment.newInstance(), this)
    }
    
    
    
}


