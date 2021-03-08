package com.vietth.gapo.presentation.features.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.vietth.gapo.core.fragment.autoCleared
import com.vietth.gapo.databinding.DetailFragmentBinding
import com.vietth.gapo.presentation.HostViewModel
import com.vietth.gapo.presentation.features.detail.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var binding by autoCleared<DetailFragmentBinding>()

    private val hostViewModel by activityViewModels<HostViewModel>()
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostViewModel.hideBottomNav()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.detailViewModel = this@DetailFragment.detailViewModel
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel.fetchData()
    }

    override fun onDetach() {
        super.onDetach()
        hostViewModel.showBottomNav()
    }

    private fun initView() {

    }
}