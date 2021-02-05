package dev.jamile.superheroes.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.jamile.superheroes.R
import dev.jamile.superheroes.databinding.HeroItemBinding
import dev.jamile.superheroes.datasource.models.Character

class HomeAdapter(
    private val context: Context,
    private val heroesList: List<Character>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HeroItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = heroesList[position]
        holder.bind(hero)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        onBindViewHolder(holder, position)
    }

    override fun getItemCount() = heroesList.size

    inner class ViewHolder(val binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.apply {
                Glide.with(context)
                    .load(character.image["thumb_url"])
                    .placeholder(R.drawable.cap)
                    .into(heroImage)
                heroNameTextView.text = character.name
                heroDescTextView.text = character.deck
                heroRealNameTextView.text = character.realName
            }
        }
    }
}