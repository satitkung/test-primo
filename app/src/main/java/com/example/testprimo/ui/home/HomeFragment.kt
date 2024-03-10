package com.example.testprimo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testprimo.databinding.FragmentHomeBinding
import com.example.testprimo.ui.home.adapter.HomeAdapter
import com.example.testsalehere.extension.observeFor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter: HomeAdapter by lazy {
        HomeAdapter { id ->
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
                .let {
                    view?.findNavController()?.navigate(it)
                }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        viewModel.loadData()
    }

    private fun initObserver() {
        observeFor(viewModel.feedList) {
            adapter.submitList(it)
        }
    }


    private fun initView() {
        binding.rcvHome.layoutManager = LinearLayoutManager(context)
        binding.rcvHome.adapter = adapter
    }

}
