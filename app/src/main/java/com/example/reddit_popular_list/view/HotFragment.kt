package com.example.reddit_popular_list.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_popular_list.R
import com.example.reddit_popular_list.view.adapter.PageAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotFragment: Fragment(R.layout.fragment_hot) {

    private val viewModel: HotViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView

    private val adapter by lazy(LazyThreadSafetyMode.NONE){
        PageAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.subscribe().observe(viewLifecycleOwner,{})
        init(view)

    }

    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.hot_recycler_view)
        recyclerView.adapter = adapter
        lifecycleScope.launch {
        viewModel.flow
                .collectLatest(adapter::submitData)
        }
    }


}