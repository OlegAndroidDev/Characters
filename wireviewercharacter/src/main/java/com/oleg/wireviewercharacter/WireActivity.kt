package com.oleg.wireviewercharacter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.oleg.anywhereapp.BaseSDK
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.wireviewercharacter.databinding.ActivityWireBinding

class WireActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWireBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWireBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BaseSDK.init(applicationContext, CharactersType.THE_WIRE)
    }
}