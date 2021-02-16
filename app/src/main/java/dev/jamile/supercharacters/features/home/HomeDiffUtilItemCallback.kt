package dev.jamile.supercharacters.features.home

import androidx.recyclerview.widget.DiffUtil
import dev.jamile.supercharacters.datasource.models.Character

class HomeDiffUtilItemCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }
}
