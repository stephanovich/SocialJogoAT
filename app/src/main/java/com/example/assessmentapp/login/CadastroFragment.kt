package com.example.assessmentapp.login

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assessmentapp.R
import com.example.assessmentapp.models.Usuario
import com.example.assessmentapp.viewmodels.RepositorioViewModels
import kotlinx.android.synthetic.main.fragment_cadastro.*


/**
 * A simple [Fragment] subclass.
 */
class CadastroFragment : Fragment() {
    lateinit var repositorioViewModels: RepositorioViewModels

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let {
            repositorioViewModels = ViewModelProviders.of(it)
                .get(RepositorioViewModels::class.java)
        }
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enviarBtn.setOnClickListener {
            var nome = nomeCadastro.text.toString()
            var steamId = steamCadastro.text.toString()
            var email = emailCadastro.text.toString()
            var senha = senhaCadastro.text.toString()
            var telefone = telefoneCadastro.text.toString()
            var idade = idadeCadastro.text.toString()
            if(nome.isNotEmpty() && steamId.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && telefone.isNotEmpty() && idade.isNotEmpty()){
                var usuario = Usuario(nome, steamId,telefone,idade.toInt() ,email, senha)
                repositorioViewModels.cadastrarUsuario(usuario)
                repositorioViewModels.email.value = email
                findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
            } else {
                Toast.makeText(activity, "Por favor preencher todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
