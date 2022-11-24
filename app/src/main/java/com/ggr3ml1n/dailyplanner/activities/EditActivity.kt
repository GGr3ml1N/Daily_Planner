package com.ggr3ml1n.dailyplanner.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ggr3ml1n.dailyplanner.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityEditBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}