package com.omni.summary.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devexy.summary.R
import com.omni.analysis_shared_data.domain.entity.IngredientEntity

class Sum(private val list: List<IngredientEntity>) : RecyclerView.Adapter<Sum.SumViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SumViewHolder.from(parent)

    override fun onBindViewHolder(holder: SumViewHolder, position: Int) {
        list[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = list.size

    class SumViewHolder private constructor(private val rootView: View) :
        RecyclerView.ViewHolder(rootView) {


        fun bind(item: IngredientEntity) {
            rootView.findViewById<TextView>(R.id.food).text = item.food
        }

        companion object {
            fun from(parent: ViewGroup): SumViewHolder =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_ingredient, parent, false)
                    .let {
                        SumViewHolder(it)
                    }
        }
    }
}