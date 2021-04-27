package com.example.leruamerlendemo.screens.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leruamerlendemo.R
import com.example.leruamerlendemo.components.adapters.CategoryAdapter


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        val categoryList = requireView().findViewById<RecyclerView>(R.id.caterogy_list)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categoryList.layoutManager = layoutManager
        val categoryAdapter = CategoryAdapter()
        viewModel.categories.observe(this) {
            categoryAdapter.setItems(it)
        }
        categoryList.adapter = categoryAdapter
    }

}