package com.example.myapplication.ui.fragment

import ai.offer_landed.fragments.BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.num.numandroidpagecurleffect.PageCurlView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentToolsBinding
import com.example.myapplication.utils.showToast

class ToolsFragment : BaseFragment<FragmentToolsBinding>(FragmentToolsBinding::inflate) {

    private lateinit var images: MutableList<Int>
    private lateinit var pageCurlView: PageCurlView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backPress {
            showToast("tools back Press")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageCurlView = requireView().findViewById(R.id.pageCurlView)

        images = mutableListOf()

        images.add(R.drawable.cv_one) // First Image
        images.add(R.drawable.cv_two) // Second Image
        images.add(R.drawable.cv_three)
        pageCurlView.setCurlView(images)
        pageCurlView.setCurlSpeed(600)

    }

}