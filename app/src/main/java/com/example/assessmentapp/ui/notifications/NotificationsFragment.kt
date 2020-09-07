package com.example.assessmentapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assessmentapp.R
import com.example.assessmentapp.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                .get(UsuarioViewModel::class.java)
        }
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        editarBtnDados.setOnClickListener{
            findNavController().navigate(R.id.editarCadastroFragment)
        }
    }

    private fun setText(){
        var formatEmail = "E-mail: " + usuarioViewModel.usuario?.email
        var formatTelefone = "Telefone: " + usuarioViewModel.usuario?.telefone
        var formatIdade = "Idade: " + usuarioViewModel.usuario?.idade.toString()
        var formatNome = "Nome: " + usuarioViewModel.usuario?.formatarCartaoPessoal()
        var formatarSteam = "Steam: " + usuarioViewModel.usuario?.steamId
        nomeText.text = formatNome
        steamText.text = formatarSteam
        emailText.text = formatEmail
        telefoneText.text = formatTelefone
        idadeText.text = formatIdade
    }
}
