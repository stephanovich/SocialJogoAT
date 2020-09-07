package com.example.assessmentapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.assessmentapp.models.Usuario
import com.example.assessmentapp.viewmodels.UsuarioViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        var usuarioViewModel = ViewModelProviders.of(this)
            .get(UsuarioViewModel::class.java)
        usuarioViewModel.usuario = intent.getSerializableExtra("usuario") as Usuario
        navView.setupWithNavController(navController)
    }
}
