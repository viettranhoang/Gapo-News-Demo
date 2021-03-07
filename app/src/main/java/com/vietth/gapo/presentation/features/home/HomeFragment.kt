package com.vietth.gapo.presentation.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.SimpleExoPlayer
import com.vietth.gapo.core.common.AppCoroutineDispatchers
import com.vietth.gapo.core.fragment.autoCleared
import com.vietth.gapo.core.glide.GlideApp
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeFragmentBinding
import com.vietth.gapo.presentation.features.home.adapter.HomeAdapter
import com.vietth.gapo.presentation.features.home.decoration.HomeNewsDecoration
import com.vietth.gapo.presentation.features.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var appCoroutineDispatcher: AppCoroutineDispatchers

    @Inject
    lateinit var exoPlayer: SimpleExoPlayer

    private var binding by autoCleared<HomeFragmentBinding>()

    private val homeViewModel by viewModels<HomeViewModel>()

    private var homeAdapter by autoCleared<HomeAdapter>()

    private lateinit var glideRequests: GlideRequests

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        homeViewModel.fetchData()

    }

    private fun initView() {
        glideRequests = GlideApp.with(this)
        homeAdapter = HomeAdapter(
            exoPlayer,
            homeViewModel,
            glideRequests,
            appCoroutineDispatcher.computation
        )
        initHomeRecyclerView()

        with(binding) {


        }
    }

    private fun initHomeRecyclerView() {
        binding.rcvHome.apply {
            adapter = homeAdapter
            addItemDecoration(HomeNewsDecoration(context))
        }
    }
}