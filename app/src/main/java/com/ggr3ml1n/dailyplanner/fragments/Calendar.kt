package com.ggr3ml1n.dailyplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggr3ml1n.dailyplanner.databinding.FragmentCalendarBinding


class Calendar : BaseFragment() {
    
    private lateinit var binding: FragmentCalendarBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onClickNew() {
        TODO("Not yet implemented")
    }
    
    companion object {
        @JvmStatic
        fun newInstance() = Calendar()
        
    }
}