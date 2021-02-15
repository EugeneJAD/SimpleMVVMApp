package com.example.simplemvvmapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.simplemvvmapp.R
import com.example.simplemvvmapp.databinding.FragmentHomeBinding
import com.example.simplemvvmapp.ui.base.BaseFragment
import com.example.simplemvvmapp.ui.home.UIState.Error
import com.example.simplemvvmapp.ui.home.UIState.Loading
import com.example.simplemvvmapp.ui.home.UIState.Success
import com.example.simplemvvmapp.utils.executeAfter


class HomeFragment(override val layoutId: Int = R.layout.fragment_home) :
        BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.executeAfter {
            vm = viewModel
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is Loading -> updateUIState("Loading")
                is Success -> updateUIState("Tasks: ${state.data.size}")
                is Error -> updateUIState("Error ${state.cause}")
            }
        }
    }

    private fun updateUIState(message: String) {
        binding.infoTextView.text = message
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}