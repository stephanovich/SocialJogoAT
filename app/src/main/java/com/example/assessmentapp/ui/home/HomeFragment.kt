package com.example.assessmentapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentapp.R
import com.example.assessmentapp.adapter.FeedAdapter
import com.example.assessmentapp.models.Status
import com.example.assessmentapp.models.Usuario
import com.example.assessmentapp.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var feedAdapter = FeedAdapter(usuarioViewModel.mensagens.asReversed())
        rcyVwHome.adapter = feedAdapter
        rcyVwHome.layoutManager = LinearLayoutManager(context)
        if(usuarioViewModel.status != null){
            var format = usuarioViewModel.usuario?.formatarCartaoPessoal() + " está " + usuarioViewModel.status
            var stats = Status(format)
            textoStatus.text = format
        }
    }
}
