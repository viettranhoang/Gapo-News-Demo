package com.vietth.gapo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.vietth.gapo.R
import com.vietth.gapo.databinding.HostActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : AppCompatActivity() {


    private lateinit var binding: HostActivityBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HostActivityBinding.inflate(LayoutInflater.from(this))
        binding.lifecycleOwner = this
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavView, navHostFragment.navController)
    }


}