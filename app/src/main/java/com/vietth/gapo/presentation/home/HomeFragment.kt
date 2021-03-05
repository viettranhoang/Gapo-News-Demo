package com.vietth.gapo.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vietth.gapo.core.fragment.autoCleared
import com.vietth.gapo.core.glide.GlideApp
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding by autoCleared<HomeFragmentBinding>()

    private lateinit var glideRequests: GlideRequests

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        glideRequests = GlideApp.with(this)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner

        }
    }
}