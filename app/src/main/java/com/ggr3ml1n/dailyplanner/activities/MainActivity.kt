package com.ggr3ml1n.dailyplanner.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ggr3ml1n.dailyplanner.R
import com.ggr3ml1n.dailyplanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setBottomNavListener()
        
    }
    
    private fun setBottomNavListener(){
        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.btn_calendar -> {
                    Toast.makeText(this, "Button Calendar has been pressed", Toast.LENGTH_SHORT).show()
                }
                R.id.plan_list -> {
                    Toast.makeText(this, "Button List has been pressed", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
    
    
    
}


