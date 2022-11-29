package com.ggr3ml1n.dailyplanner.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.ggr3ml1n.dailyplanner.R

import com.ggr3ml1n.dailyplanner.databinding.ActivityEditBinding
import com.ggr3ml1n.dailyplanner.entities.Plan
import com.ggr3ml1n.dailyplanner.fragments.ListOfPlans

class EditActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityEditBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
        Log.d("MyLog", "3 ${intent.getLongExtra(ListOfPlans.DATE, 0)}")
        showPopUpMenu()
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.upper_edit_plan_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.save_plan -> setMainResult()
        }
        return super.onOptionsItemSelected(item)
    }
    
    //Простите за это г*внокод, я ничего не смог придумать лучше :с
    private fun setStartTimePopUpMenu(): PopupMenu {
        val popupMenu = PopupMenu(this, binding.tvSettedTime)
        popupMenu.inflate(R.menu.submenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.time1 -> binding.tvSettedTime.text = getString(R.string.time1)
                R.id.time2 -> binding.tvSettedTime.text = getString(R.string.time2)
                R.id.time3 -> binding.tvSettedTime.text = getString(R.string.time3)
                R.id.time4 -> binding.tvSettedTime.text = getString(R.string.time4)
                R.id.time5 -> binding.tvSettedTime.text = getString(R.string.time5)
                R.id.time6 -> binding.tvSettedTime.text = getString(R.string.time6)
                R.id.time7 -> binding.tvSettedTime.text = getString(R.string.time7)
                R.id.time8 -> binding.tvSettedTime.text = getString(R.string.time8)
                R.id.time9 -> binding.tvSettedTime.text = getString(R.string.time9)
                R.id.time10 -> binding.tvSettedTime.text = getString(R.string.time10)
                R.id.time11 -> binding.tvSettedTime.text = getString(R.string.time11)
                R.id.time12 -> binding.tvSettedTime.text = getString(R.string.time12)
                R.id.time13 -> binding.tvSettedTime.text = getString(R.string.time13)
                R.id.time14 -> binding.tvSettedTime.text = getString(R.string.time14)
                R.id.time15 -> binding.tvSettedTime.text = getString(R.string.time15)
                R.id.time16 -> binding.tvSettedTime.text = getString(R.string.time16)
                R.id.time17 -> binding.tvSettedTime.text = getString(R.string.time17)
                R.id.time18 -> binding.tvSettedTime.text = getString(R.string.time18)
                R.id.time19 -> binding.tvSettedTime.text = getString(R.string.time19)
                R.id.time20 -> binding.tvSettedTime.text = getString(R.string.time20)
                R.id.time21 -> binding.tvSettedTime.text = getString(R.string.time21)
                R.id.time22 -> binding.tvSettedTime.text = getString(R.string.time22)
                R.id.time23 -> binding.tvSettedTime.text = getString(R.string.time23)
                R.id.time24 -> binding.tvSettedTime.text = getString(R.string.time24)
                
            }
            true
        }
        return popupMenu
    }
    
    private fun showPopUpMenu() {
        binding.tvSettedTime.setOnClickListener {
            setStartTimePopUpMenu().show()
        }
    }
    
    private fun createNewPlan(): Plan {
        return Plan(
            null,
            binding.edTitle.text.toString(),
            binding.edDesc.text.toString(),
            binding.tvSettedTime.text
                .toString()
                .substring(0..1)
                .toLong()
                .times(3600000L)
                .plus(intent.getLongExtra(ListOfPlans.DATE, 0))
                .toString(),
            binding.tvSettedTime.text
                .toString()
                .substring(8..9)
                .toLong()
                .times(3600000L)
                .plus(intent.getLongExtra(ListOfPlans.DATE, 0))
                .toString(),
        )
    }
    
    private fun setMainResult() {
        setResult(
            RESULT_OK,
            Intent()
                .apply {
                    putExtra(
                        ListOfPlans.PLAN,
                        createNewPlan(),
                    )
                },
        )
        finish()
        
    }
    
    private fun actionBarSettings() {
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }
}