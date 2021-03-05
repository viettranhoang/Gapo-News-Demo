package com.vietth.gapo.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vietth.gapo.R
import com.vietth.gapo.core.fragment.autoCleared
import com.vietth.gapo.core.glide.GlideApp
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.AccountFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private var binding by autoCleared<AccountFragmentBinding>()

    private lateinit var glideRequests: GlideRequests

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountFragmentBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        glideRequests = GlideApp.with(this)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner

            btnNotificationDetails.setOnClickListener {
                findNavController().navigate(R.id.action_accountFragment_to_detailFragment)
            }
        }
    }
}