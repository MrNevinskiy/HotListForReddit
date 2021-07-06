package com.example.reddit_popular_list.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_popular_list.R
import com.example.reddit_popular_list.model.AppState
import com.example.reddit_popular_list.model.repo.HotList
import com.example.reddit_popular_list.view.adapter.HotAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotFragment: Fragment(R.layout.fragment_hot) {

    private val viewModel: HotViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
        init(view)
    }

    private fun renderData(appState: AppState?) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is HotList -> {
                        recyclerView.adapter = HotAdapter(appState.data)
                    }
                }
            }
            else -> Toast.makeText(context, "ErrorData", Toast.LENGTH_LONG).show()
        }
    }

    private fun init(view: View) {
        viewModel.getListOfHot()
        recyclerView = view.findViewById(R.id.hot_recycler_view)
    }


}