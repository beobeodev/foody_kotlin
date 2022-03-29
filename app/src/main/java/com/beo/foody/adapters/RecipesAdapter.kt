package com.beo.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beo.foody.databinding.RecipesRowLayoutBinding
import com.beo.foody.models.FoodRecipe
import com.beo.foody.models.Result

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
        listRecipe = newData.results
        notifyDataSetChanged() 
    }
}