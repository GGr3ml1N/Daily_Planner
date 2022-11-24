package com.ggr3ml1n.dailyplanner.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggr3ml1n.dailyplanner.R


class ListOfPlans : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_plans, container, false)
    }
    
    companion object {
        
        @JvmStatic
        fun newInstance() = ListOfPlans()
    }
}