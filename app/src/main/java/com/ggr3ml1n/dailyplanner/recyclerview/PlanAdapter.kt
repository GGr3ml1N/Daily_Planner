package com.ggr3ml1n.dailyplanner.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggr3ml1n.dailyplanner.R
import com.ggr3ml1n.dailyplanner.databinding.PlanItemBinding
import com.ggr3ml1n.dailyplanner.entities.Plan

class PlanAdapter() : ListAdapter<Plan,PlanAdapter.PlanHolder>(ItemComparator()) {
    
    val planList: ArrayList<Plan> = ArrayList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder =
        PlanHolder.create(parent)
    
    
    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    fun addPlan(plan: Plan) {
        planList.add(plan)
        notifyDataSetChanged()
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
    class ItemComparator : DiffUtil.ItemCallback<Plan>() {
        
        override fun areItemsTheSame(oldItem: Plan, newItem: Plan): Boolean =
            oldItem.id == newItem.id
        
        override fun areContentsTheSame(oldItem: Plan, newItem: Plan): Boolean =
            oldItem == newItem
        
    }
}