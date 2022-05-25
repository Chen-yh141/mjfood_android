package com.lee989898.todayeat.src.recommendFoodList

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lee989898.todayeat.R
import com.lee989898.todayeat.databinding.FragmentRecommendFoodListBinding
import com.lee989898.todayeat.src.recommendFoodList.adapter.RFLAdapter
import com.lee989898.todayeat.src.recommendFoodList.adapter.RFLAdapter.ItemViewHolder
import com.lee989898.todayeat.src.recommendFoodList.data.RFLDataSource

//recommendFoodlist `s fragment
class RecommendFoodList : Fragment() {
    private lateinit var binding : FragmentRecommendFoodListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendFoodListBinding.inflate(inflater,container,false)
        val myDataset = RFLDataSource().loadRecommendFood()
        binding.recyclerview.adapter = RFLAdapter(this.requireContext(),myDataset)
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_recommendFoodList_to_recommendResults)
        }
        return binding.root
    }

}