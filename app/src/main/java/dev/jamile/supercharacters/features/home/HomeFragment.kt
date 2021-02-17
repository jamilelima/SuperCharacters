package dev.jamile.supercharacters.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dev.jamile.supercharacters.R
import dev.jamile.supercharacters.base.BaseFragment
import dev.jamile.supercharacters.databinding.FragmentHomeBinding
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

@InternalCoroutinesApi
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: HomeAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.getAllCharacters().collectLatest { adapter.submitData(it) }
        }
    }

    private fun setupAdapter() {
        adapter = HomeAdapter(HomeDiffUtilItemCallback())
        binding.homeRecyclerView.adapter = adapter.withLoadStateFooter(
            footer = HomeLoadStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener { combinedLoadStates ->
            when (combinedLoadStates.source.append) {
                is LoadState.NotLoading -> {
                    binding.progressBar.isVisible = false
                    binding.homeRecyclerView.isVisible = true
                }
                is LoadState.Loading -> {
                    binding.noDataDesc.isVisible = false
                    binding.noDataImg.isVisible = false
                }
                is LoadState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.noDataDesc.isVisible = true
                    binding.noDataImg.isVisible = true
                }
            }
            val errorState = combinedLoadStates.source.append as? LoadState.Error
                ?: combinedLoadStates.append as? LoadState.Error
            errorState?.let {
                snackBarError(
                    requireView(),
                    it.error.localizedMessage ?: getString(R.string.default_error_snack)
                )
            }
        }
    }
}