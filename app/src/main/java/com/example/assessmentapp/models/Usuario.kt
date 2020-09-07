package com.example.assessmentapp.models

import java.io.Serializable

class Usuario(var nome: String, var steamId: String,
              var telefone: String, var idade: Int,
              var email: String, var senha: String
) : Serializable {
    var id: Int = -1
    fun formatarCartaoPessoal(): String{
        var nomeFormatado = ""
        val nomes = nome.split(" ").toMutableList()
        for(name in nomes){
            nomeFormatado += name.capitalize() + " "
        }
        nomeFormatado = nomeFormatado.trim()
        return nomeFormatado
    }
}

