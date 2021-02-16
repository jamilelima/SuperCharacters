package dev.jamile.supercharacters.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dev.jamile.supercharacters.R
import dev.jamile.supercharacters.databinding.CharacterItemBinding
import dev.jamile.supercharacters.datasource.models.Character

class HomeAdapter(diffCallback: DiffUtil.ItemCallback<Character>) :
    PagingDataAdapter<Character, RecyclerView.ViewHolder>(diffCallback) {
    private lateinit var context: Context

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder) {
            val character = getItem(position)
            holder.bind(character)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val characterListItemBinding = CharacterItemBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(characterListItemBinding)
    }

    inner class HomeViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character?) {
            if (character != null) {
                binding.apply {
                    Glide.with(context)
                        .load(character.image["thumb_url"])
                        .placeholder(R.drawable.cap)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(characterImage)
                    characterNameTextView.text = character.name
                    characterDescTextView.text = character.deck
                    characterRealNameTextView.text = character.realName
                }
            }
        }
    }
}