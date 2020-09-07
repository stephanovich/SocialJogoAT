package com.example.assessmentapp.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assessmentapp.R
import com.example.assessmentapp.models.Status
import com.example.assessmentapp.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

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
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nomeUsuario.text = usuarioViewModel.usuario?.formatarCartaoPessoal()
        steamId.text = "Steam: " + usuarioViewModel.usuario?.steamId
        postarBtn.setOnClickListener{
            if(statusPerfil.text.toString().isNotEmpty()) {
                Toast.makeText(activity, "Postando...", Toast.LENGTH_SHORT).show()
                var s = Status("Jogando " + statusPerfil.text.toString())
                usuarioViewModel.status = s.mensagem
                s.usuario = usuarioViewModel.usuario
                usuarioViewModel.mensagens.add(s)
                view.hideKeyboard()
                findNavController().navigate(R.id.navigation_home)
            }
        }
    }
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
