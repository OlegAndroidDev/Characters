package com.oleg.simpsons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oleg.anywhereapp.BaseSDK
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.codebasesdk.databinding.ActivityMainBinding

class SimpsonsActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BaseSDK.init(applicationContext, CharactersType.SIMPSONS)
    }
}