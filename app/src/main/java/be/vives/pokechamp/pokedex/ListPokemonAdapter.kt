package be.vives.pokechamp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import be.vives.pokechamp.databinding.DetailPokemonNameBinding
import be.vives.pokechamp.model.Results

class ListPokemonAdapter(val clickListener: PokemonClickListener): ListAdapter<Results, ListPokemonAdapter.ViewHolder>(ToDoDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: DetailPokemonNameBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            results: Results,
            clickListener: PokemonClickListener
        ) {
            binding.pokemon = results
            binding.clickListener = clickListener

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DetailPokemonNameBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
class ToDoDiffCallback : DiffUtil.ItemCallback<Results>() {

    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}

class PokemonClickListener(val clickListener: (results: Results) -> Unit) {
    fun onClick(results: Results) = clickListener(results)
}