package dev.jamile.supercharacters.features.home

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class HomeLoadStateAdapter (private val retry: () -> Unit) :
    LoadStateAdapter<HomeStateViewHolder>() {
    override fun onBindViewHolder(holder: HomeStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): HomeStateViewHolder {
        return HomeStateViewHolder.create(parent, retry)
    }
}