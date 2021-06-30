package com.omni.summary.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devexy.summary.databinding.IngredientItemHeaderBinding
import com.devexy.summary.databinding.ListItemIngredientBinding
import com.omni.analysis_shared_data.domain.entity.IngredientEntity

class SummaryAdapter(private val list: List<IngredientEntity>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_ITEM ->
                SummaryViewHolder(ListItemIngredientBinding.inflate(layoutInflater, parent, false))
            VIEW_TYPE_HEADER -> {
                SummaryHeaderViewHolder(
                    IngredientItemHeaderBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalStateException("Settings view holder for type $viewType")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SummaryViewHolder ->
                holder.bind(list[position-1])

            is SummaryHeaderViewHolder -> {
            }
            else -> throw IllegalStateException("Settings view holder for type ${holder.itemViewType}")
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_ITEM

        }

    override fun getItemCount(): Int = list.size + 1

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }
}