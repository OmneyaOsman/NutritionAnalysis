package com.omni.summary.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devexy.summary.databinding.ListItemIngredientBinding
import com.omni.analysis_shared_data.domain.entity.IngredientEntity

class SummaryAdapter(private val list: List<IngredientEntity>) :
    RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>() {


    class SummaryViewHolder(private val binding: ListItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredientEntity: IngredientEntity) {
            binding.calories.text = ingredientEntity.calories
            binding.ingredient = ingredientEntity
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        LayoutInflater.from(parent.context).let {
            ListItemIngredientBinding.inflate(it, parent, false)
        }.also { return SummaryViewHolder(it) }
    }


    override fun getItemCount(): Int = list.count()
    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        holder.bind(list[position])
    }
}