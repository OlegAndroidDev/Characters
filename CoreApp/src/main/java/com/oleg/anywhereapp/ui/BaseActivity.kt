package com.oleg.anywhereapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.oleg.anywhereapp.R
import com.oleg.anywhereapp.databinding.ActivityBaseBinding
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.anywhereapp.viewmodel.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityBaseBinding.inflate(layoutInflater)
    }

    private val baseViewModel by lazy {
        ViewModelProvider(this)[BaseViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        baseViewModel.charactersType =
            intent.getSerializableExtra("CHARACTERS_TYPE") as CharactersType

        val host = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        host.retainInstance = true
        setupActionBarWithNavController(host.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.frag_container).navigateUp() || super.onSupportNavigateUp()
    }
}