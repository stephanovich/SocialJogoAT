package com.example.assessmentapp.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assessmentapp.MainActivity
import com.example.assessmentapp.R
import com.example.assessmentapp.viewmodels.RepositorioViewModels
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repositorioViewModels.email.observe(viewLifecycleOwner, Observer {
            emailLogin.setText(it)
        })
        loginBtn.setOnClickListener {

            var email = emailLogin.text.toString()
            var senha = senhaLogin.text.toString()
            var id = -1
            id = repositorioViewModels.autenticarLogin(email, senha)
            if(id != -1){
                var usuario = repositorioViewModels.obterPorId(id)
                //if(usuario != null){
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.putExtra("usuario", usuario)
                    startActivity(intent)
            //}
            } else {
                Toast.makeText(activity, "Usuário ou Senha Inválidos!", Toast.LENGTH_SHORT).show()
            }

        }
        cadastroBtn.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }
        twitterBtn.setOnClickListener{
            seguir()
        }
    }
    private fun seguir(){
        val url = "https://twitter.com/Erikstephanovic"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        val packageManager = activity!!.packageManager
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        }
    }
}
