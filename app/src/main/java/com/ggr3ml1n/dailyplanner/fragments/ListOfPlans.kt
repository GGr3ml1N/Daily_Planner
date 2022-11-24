package com.ggr3ml1n.dailyplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ggr3ml1n.dailyplanner.activities.MainApp
import com.ggr3ml1n.dailyplanner.databinding.FragmentListOfPlansBinding
import com.ggr3ml1n.dailyplanner.mainviewmodel.MainViewModel


class ListOfPlans : BaseFragment() {
    
    private lateinit var binding: FragmentListOfPlansBinding
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfPlansBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onClickNew() {
        TODO("Not yet implemented")
    }
    
    companion object {
        
        @JvmStatic
        fun newInstance() = ListOfPlans()
    }
}