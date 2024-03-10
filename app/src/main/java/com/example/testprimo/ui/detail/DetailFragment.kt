package com.example.testprimo.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testprimo.databinding.FragmentDetailBinding
import com.example.testprimo.extension.findFirstIndex
import com.example.testprimo.extension.findLastIndex
import com.example.testsalehere.extension.observeFor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        arguments?.let {
            viewModel.loadDetail(DetailFragmentArgs.fromBundle(it).ID)
        }
    }

    private fun initObserver() {
        observeFor(viewModel.feedDetail) {
            val start = it.detail.findFirstIndex("<p>")
            val end = it.detail.findLastIndex("</p>")
            binding.txtDetail.text =
                HtmlCompat.fromHtml(it.detail.substring(start, end), HtmlCompat.FROM_HTML_MODE_LEGACY);
        }
    }


}