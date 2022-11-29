package com.ggr3ml1n.dailyplanner.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.ggr3ml1n.dailyplanner.activities.EditActivity
import com.ggr3ml1n.dailyplanner.activities.MainApp
import com.ggr3ml1n.dailyplanner.databinding.FragmentListOfPlansBinding
import com.ggr3ml1n.dailyplanner.entities.Plan
import com.ggr3ml1n.dailyplanner.mainviewmodel.MainViewModel
import com.ggr3ml1n.dailyplanner.recyclerview.PlanAdapter
import java.text.SimpleDateFormat
import java.util.*


class ListOfPlans : BaseFragment() {
    
    private lateinit var binding: FragmentListOfPlansBinding
    private lateinit var editPlan: ActivityResultLauncher<Intent>
    private lateinit var adapter: PlanAdapter
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    private var currentDate = getCurrentDayTime()
    private var dateFromCalendar: Long? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEditResult()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfPlansBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("MyLog", "Тут должны запуститься методы")
        initRcView()
        observer()
        
        Log.d("MyLog", "1 $dateFromCalendar")
        
        mainViewModel.messageForListOfPlans.observe(activity as LifecycleOwner) {
            dateFromCalendar = it.toLong()
            Log.d("MyLog", " 2 $dateFromCalendar")
        }
        
        
        binding.btnNewPlan.setOnClickListener {
            editPlan.launch(Intent(requireActivity(), EditActivity::class.java).apply {
                putExtra(DATE, dateFromCalendar ?: currentDate)
            })
        }
    }
    
    private fun onEditResult() {
        editPlan = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                Log.d("MyLog", " ${it.data?.getSerializableExtra(PLAN)}")
                mainViewModel.insertPlan(it.data?.getSerializableExtra(PLAN) as Plan)
            }
        }
    }
    
    private fun initRcView() = with(binding) {
        rcViewPlan.layoutManager = LinearLayoutManager(activity)
        adapter = PlanAdapter()
        rcViewPlan.adapter = adapter
    }
    
    private fun observer() {
        mainViewModel.allPlans.observe(viewLifecycleOwner) {
           adapter.submitList(it)
        }
    }
    
    override fun onClickNew() {
    
    }
    
    companion object {
        
        const val PLAN = "plan"
        const val DATE = "current_or_selected_date"
        
        @JvmStatic
        fun newInstance() = ListOfPlans()
    }
    
    private fun getCurrentDayTime(): Long {
        val date = Date()
        val dateFormat = SimpleDateFormat("dd MM yyyy", Locale.getDefault()).format(date)
        val currentDate = SimpleDateFormat("dd MM yyyy", Locale.getDefault()).parse(dateFormat)!!
        return currentDate.time
    }
}