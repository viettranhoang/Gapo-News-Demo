package com.vietth.gapo.presentation.features.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vietth.gapo.core.fragment.autoCleared
import com.vietth.gapo.core.glide.GlideApp
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.DetailFragmentBinding
import com.vietth.gapo.presentation.HostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var binding by autoCleared<DetailFragmentBinding>()

    private val hostViewModel by activityViewModels<HostViewModel>()


    private lateinit var glideRequests: GlideRequests

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostViewModel.showBottomNav()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        hostViewModel.hideBottomNav()
    }

    private fun initView() {
        glideRequests = GlideApp.with(this)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner

        }
    }
}