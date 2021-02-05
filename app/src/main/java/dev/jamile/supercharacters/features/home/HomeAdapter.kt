package dev.jamile.supercharacters.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.jamile.supercharacters.R
import dev.jamile.supercharacters.databinding.CharacterItemBinding
import dev.jamile.supercharacters.datasource.models.Character

class HomeAdapter(
        private val context: Context,
        private val charactersList: List<Character>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = charactersList[position]
        holder.bind(character)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        onBindViewHolder(holder, position)
    }

    override fun getItemCount() = charactersList.size

    inner class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.apply {
                Glide.with(context)
                        .load(character.image["thumb_url"])
                        .placeholder(R.drawable.cap)
                        .into(characterImage)
                characterNameTextView.text = character.name
                characterDescTextView.text = character.deck
                characterRealNameTextView.text = character.realName
            }
        }
    }
}