package com.omni.total_nutrition.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omni.analysis_shared_data.data.model.response.CustomNutritionDataModel
import com.omni.total_nutrition.databinding.ListItemTotalNutritionBinding

class TotalNutritionAdapter(private val data: List<CustomNutritionDataModel>) :
    RecyclerView.Adapter<TotalNutritionAdapter.TotalNutritionViewHolder>() {
    class TotalNutritionViewHolder(private val binding: ListItemTotalNutritionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CustomNutritionDataModel) {
            binding.nutritionDataItem = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TotalNutritionViewHolder =
        LayoutInflater.from(parent.context)
            .let { ListItemTotalNutritionBinding.inflate(it, parent, false) }.let {
                TotalNutritionViewHolder(it)
            }

    override fun onBindViewHolder(holder: TotalNutritionViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.count()
}


