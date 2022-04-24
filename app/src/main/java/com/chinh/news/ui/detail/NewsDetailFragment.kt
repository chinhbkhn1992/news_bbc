package com.chinh.news.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.chinh.news.R
import com.chinh.news.databinding.NewsDetailFragmentBinding
import com.chinh.news.repository.model.NewsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    companion object {
        fun newInstance() = NewsDetailFragment()
    }

    private lateinit var viewModel: NewsDetailViewModel
    private lateinit var binding: NewsDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsDetailFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewsDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (arguments?.getSerializable("item") as? NewsModel)?.apply {
            binding.item = this
            (activity as? AppCompatActivity)?.supportActionBar?.title = title
        }
    }
}