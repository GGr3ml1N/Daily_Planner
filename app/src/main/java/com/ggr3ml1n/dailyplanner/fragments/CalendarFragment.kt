package com.ggr3ml1n.dailyplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ggr3ml1n.dailyplanner.activities.MainApp
import com.ggr3ml1n.dailyplanner.databinding.FragmentCalendarBinding
import com.ggr3ml1n.dailyplanner.mainviewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*


class CalendarFragment : BaseFragment() {
    
    private lateinit var binding: FragmentCalendarBinding
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDay = SimpleDateFormat(
                "dd MM yyyy",
                Locale.getDefault(),
            ).parse("$dayOfMonth ${month + 1} $year")
                ?.time
                .toString()
            binding.tvChoose.text = selectedDay
           mainViewModel.messageForListOfPlans.value = selectedDay
        }
        
    }
    
    override fun onClickNew() {}
    
    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
        
    }
}