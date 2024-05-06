package com.example.myapplication.ui.fragment

import ai.offer_landed.fragments.BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentToolsBinding
import com.example.myapplication.utils.showToast

class ToolsFragment : BaseFragment<FragmentToolsBinding>(FragmentToolsBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backPress {
            showToast("tools back Press")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}