package com.example.assessmentapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.assessmentapp.models.Status
import com.example.assessmentapp.models.Usuario

class UsuarioViewModel() : ViewModel() {
    var usuario: Usuario? = null
    var status: String? = null
    var mensagens = mutableListOf(gerarStatus())

    fun gerarStatus(): Status{
        var s = Status("Jogando League of Legends")
        s.usuario = Usuario("amy swanz","amyswanz","99999999", 28, "amy@email.com", "amy1234")
        return s
    }
}