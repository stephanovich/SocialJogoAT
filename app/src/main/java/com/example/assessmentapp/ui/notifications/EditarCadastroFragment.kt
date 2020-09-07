package com.example.assessmentapp.ui.notifications

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assessmentapp.R
import com.example.assessmentapp.viewmodels.UsuarioViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_editar_cadastro.*

/**
 * A simple [Fragment] subclass.
 */
class EditarCadastroFragment : Fragment() {
    lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                .get(UsuarioViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_editar_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        enviarEditBtn.setOnClickListener {
            if(edicaoCadastro())
                view.hideKeyboard()
                findNavController().navigate(R.id.navigation_notifications)
        }
    }
    private fun setText(){
        nomeEdit.setText(usuarioViewModel.usuario?.formatarCartaoPessoal())
        steamEdit.setText(usuarioViewModel.usuario?.steamId)
        emailEdit.setText(usuarioViewModel.usuario?.email)
        telefoneEdit.setText(usuarioViewModel.usuario?.telefone)
        senhaEdit.setText(usuarioViewModel.usuario?.senha)
    }
    private fun edicaoCadastro(): Boolean{
        var nome = nomeEdit.text.toString()
        var steamId = steamEdit.text.toString()
        var email = emailEdit.text.toString()
        var senha = senhaEdit.text.toString()
        var telefone = telefoneEdit.text.toString()
        if(nome.isNotEmpty() && steamId.isNotEmpty() && email.isNotEmpty()
            && senha.isNotEmpty() && telefone.isNotEmpty()){
            usuarioViewModel.usuario?.nome = nome
            usuarioViewModel.usuario?.steamId = steamId
            usuarioViewModel.usuario?.email = email
            usuarioViewModel.usuario?.senha = senha
            usuarioViewModel.usuario?.telefone = telefone
            return true
        } else {
            Toast.makeText(activity, "Por favor preencher todos os dados!", Toast.LENGTH_SHORT).show()
            return false
        }
    }
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
