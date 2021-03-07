package com.vietth.gapo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.vietth.gapo.R
import com.vietth.gapo.databinding.HostActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : AppCompatActivity() {


    private lateinit var binding: HostActivityBinding

    private val hostViewModel by viewModels<HostViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HostActivityBinding.inflate(LayoutInflater.from(this))
        binding.lifecycleOwner = this
        binding.hostViewModel = hostViewModel
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavView, navHostFragment.navController)
    }


}