package dev.jamile.supercharacters.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import dev.jamile.supercharacters.databinding.FailureLayoutBinding

class HomeStateViewHolder(
    private val binding: FailureLayoutBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    
    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            // TODO: setup error here
        }
        binding.progressbar.isVisible = loadState is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): HomeStateViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = FailureLayoutBinding.inflate(layoutInflater, parent, false)
            return HomeStateViewHolder(binding, retry)
        }
    }
}
