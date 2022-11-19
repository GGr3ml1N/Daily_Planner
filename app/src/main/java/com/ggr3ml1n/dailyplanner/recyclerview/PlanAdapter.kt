package com.ggr3ml1n.dailyplanner.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ggr3ml1n.dailyplanner.R
import com.ggr3ml1n.dailyplanner.databinding.PlanItemBinding
import com.ggr3ml1n.dailyplanner.entities.Plan

class PlanAdapter() : RecyclerView.Adapter<PlanAdapter.PlanHolder>() {
    
    val planList: ArrayList<Plan> = ArrayList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder =
        PlanHolder.create(parent)
    
    
    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        holder.bind(planList[position])
    }
    
    override fun getItemCount(): Int = planList.size
    
    fun addPlan(plan: Plan) {
        planList.add(plan)
        notifyItemInserted(planList.size-1)
    }
    
    class PlanHolder(item: View) : RecyclerView.ViewHolder(item) {
        
        private val binding = PlanItemBinding.bind(item)
        
        fun bind(plan: Plan) {
            binding.apply {
                tvName.text = plan.name
                tvDescr.text = plan.description
            }
        }
        
        companion object {
            fun create(parent: ViewGroup): PlanHolder = PlanHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.plan_item,
                    parent,
                    false,
                )
            )
        }
        
    }
}