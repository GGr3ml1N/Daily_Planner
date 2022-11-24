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

class PlanAdapter(private val listener: Listener) : ListAdapter<Plan, PlanAdapter.PlanHolder>(ItemComparator()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder =
        PlanHolder.create(parent)
    
    
    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        holder.setData(getItem(position), listener)
        notifyItemInserted(position)
    }
    
    class PlanHolder(item: View) : RecyclerView.ViewHolder(item) {
        
        private val binding = PlanItemBinding.bind(item)
        
        fun setData(plan: Plan, listener: Listener) = with(binding) {
            binding.tvName.text = plan.name
            binding.tvData.text = "${plan.dateStart} - ${plan.dateFinish}"
            itemView.setOnClickListener {
                listener.onClick(plan)
            }
        }
        
        companion object {
            fun create(parent: ViewGroup): PlanHolder = PlanHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(
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
        
        
        override fun areContentsTheSame(oldItem: Plan, newItem: Plan): Boolean = oldItem == newItem
    }
    
    interface Listener {
        fun onClick(plan: Plan)
    }
}
