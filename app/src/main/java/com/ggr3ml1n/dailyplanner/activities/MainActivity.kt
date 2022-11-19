package com.ggr3ml1n.dailyplanner.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.ggr3ml1n.dailyplanner.databinding.ActivityMainBinding
import com.ggr3ml1n.dailyplanner.entities.Plan
import com.ggr3ml1n.dailyplanner.recyclerview.PlanAdapter

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val adapter = PlanAdapter()
    private lateinit var launcher: ActivityResultLauncher<Intent>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                
                val name = it.data?.getStringExtra("plan.name")
                val desc = it.data?.getStringExtra("plan.desc")
                val plan = Plan(name!!, desc!!)
                adapter.addPlan(plan)
            }
        }
        
    }
    
    fun init(){
        binding.apply {
            rView.layoutManager = LinearLayoutManager(this@MainActivity)
            rView.adapter = adapter
            bAddPlan.setOnClickListener {
                launcher.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}

