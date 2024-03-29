package com.beo.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.beo.foody.databinding.RecipesRowLayoutBinding
import com.beo.foody.models.FoodRecipe
import com.beo.foody.models.Result
import com.beo.foody.util.RecipessDifferentUtil

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {
    private var listRecipe = emptyList<Result>()

    class RecipesViewHolder(private val binding : RecipesRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result : Result) {
            binding.result = result
            // this function will update layout whenever there is a change inside data
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : RecipesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return RecipesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesAdapter.RecipesViewHolder {
        return RecipesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val currentResult = listRecipe[position]
        holder.bind(currentResult)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    fun setData(newData: FoodRecipe) {
        // calculate different of old list and new list
        val recipesDiffUtil = RecipessDifferentUtil(listRecipe, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        listRecipe = newData.results
        // dispatch update if new changes, help improve performance instead of using notifyDataSetChanged()
        diffUtilResult.dispatchUpdatesTo(this)
    }
}