package dev.jamile.supercharacters.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dev.jamile.supercharacters.R
import dev.jamile.supercharacters.base.BaseFragment
import dev.jamile.supercharacters.databinding.FragmentHomeBinding
import dev.jamile.supercharacters.datasource.models.Character
import dev.jamile.supercharacters.features.home.HomeViewState.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

@InternalCoroutinesApi
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

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
        viewModel.getSuperCharacters()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.homeStateFlow.collect { setupViewState(it) }
        }
    }

    private fun setupViewState(homeViewState: HomeViewState) {
        when (homeViewState) {
            is Loading -> showLoading()
            is Success -> showCharacters(homeViewState.data)
            is NetworkError -> showError()
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showCharacters(charactersList: List<Character>) {
        binding.apply {
            progressBar.visibility = View.GONE
            homeRecyclerView?.apply {
                visibility = View.VISIBLE
                layoutManager = LinearLayoutManager(requireContext())
                adapter = HomeAdapter(requireContext(), charactersList)
            }
        }
    }

    private fun showError() {

    }

}