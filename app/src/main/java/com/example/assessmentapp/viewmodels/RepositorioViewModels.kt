package com.example.assessmentapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmentapp.models.Usuario

class RepositorioViewModels : ViewModel() {
    var usuarios = mutableListOf<Usuario>()
    var email = MutableLiveData<String>().apply {
        value = ""
    }
    fun autenticarLogin(e: String, senha: String): Int{
        usuarios.forEach{
            if(e == it.email && senha == it.senha){
                return it.id
            }
        }
        return -1
    }
    fun cadastrarUsuario(usuario: Usuario){
        if(usuario != null)
            usuario.id = gerarId()
            usuarios.add(usuario)
    }
    private fun gerarId(): Int{
        var id = -1
        if(usuarios.isEmpty()){
            id = 1
        } else {
            id = usuarios.lastIndex + 1
        }
        return id
    }
    fun obterPorId(id: Int): Usuario? {
        usuarios.forEach{
            if(id == it.id)
                return it
        }
        return null
    }
}