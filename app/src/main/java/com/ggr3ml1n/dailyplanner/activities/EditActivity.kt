package com.ggr3ml1n.dailyplanner.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ggr3ml1n.dailyplanner.databinding.ActivityEditBinding
import com.ggr3ml1n.dailyplanner.entities.Plan

class EditActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityEditBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    
        binding.button.setOnClickListener {
        
            val plan = Plan(binding.edTitle.text.toString(), binding.edDesc.text.toString())
            val editIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("plan.name", plan.name)
                putExtra("plan.desc", plan.description)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}