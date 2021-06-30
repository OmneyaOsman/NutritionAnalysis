package com.omni.summary.presentation.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.devexy.summary.databinding.ListItemIngredientBinding
import com.omni.analysis_shared_data.domain.entity.IngredientEntity

class SummaryViewHolder(private val binding: ListItemIngredientBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(ingredientEntity: IngredientEntity) {
        binding.ingredient = ingredientEntity
        binding.executePendingBindings()
    }
}