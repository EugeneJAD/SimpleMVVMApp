package com.example.simplemvvmapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.simplemvvmapp.R
import com.example.simplemvvmapp.databinding.FragmentHomeBinding
import com.example.simplemvvmapp.ui.base.BaseFragment
import com.example.simplemvvmapp.utils.executeAfter


class HomeFragment(override val layoutId: Int = R.layout.fragment_home) :
        BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.executeAfter {
            vm = viewModel
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}