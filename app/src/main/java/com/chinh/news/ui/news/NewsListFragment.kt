package com.chinh.news.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import com.chinh.news.R
import com.chinh.news.databinding.NewsListFragmentBinding
import com.chinh.news.repository.model.NewsModel
import com.chinh.news.ui.adapter.NewsListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsListFragment : Fragment(), NewsListView {
    private lateinit var binding: NewsListFragmentBinding
    private val adapter by lazy {
        NewsListAdapter(this::onClickItemNews)
    }

    companion object {
        fun newInstance() = NewsListFragment()
    }

    private val viewModel: NewsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsListFragmentBinding.inflate(inflater, container, false)
        viewModel.view = this
        binding.listNews.apply {
            this.adapter = this@NewsListFragment.adapter
            itemAnimator = DefaultItemAnimator()

            val horizontalDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
            val horizontalDivider =
                ContextCompat.getDrawable(activity!!, R.drawable.horizontal_divider)
            horizontalDecoration.setDrawable(horizontalDivider!!)
            addItemDecoration(horizontalDecoration)
        }
        binding.swRefresh.setOnRefreshListener {
            viewModel.startLoadData()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startLoadData()
    }

    override fun showLoading(loading: Boolean) {
        binding.swRefresh.isRefreshing = loading
    }

    override fun handleResult(data: List<NewsModel>?) {
        data?.let {
            adapter.setItems(it)
        }
    }

    override fun handleError(exception: String) {

    }


    private fun onClickItemNews(item: NewsModel) {
        val navi = findNavController()
        val bundle = Bundle()
        bundle.putSerializable("item", item)
        navi.navigate(R.id.newsDetailFragment, bundle)
    }

}