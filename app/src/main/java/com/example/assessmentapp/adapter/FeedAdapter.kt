package com.example.assessmentapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentapp.R
import com.example.assessmentapp.models.Status
import kotlinx.android.synthetic.main.feed_recycle.view.*

//    //val callback : (Usuario) -> Unit
class FeedAdapter (
    val mensagens : List<Status>
)    : RecyclerView.Adapter<FeedAdapter.UsuarioViewHolder>(){

    class UsuarioViewHolder(view : View)
        : RecyclerView.ViewHolder(view) {
        val campoNome = view.nomeStatus
        val campoStatus = view.statusStatus
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UsuarioViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.feed_recycle, // Representa um item
                parent,false
            )
        val usuarioViewHolder = UsuarioViewHolder(v)

//        usuarioViewHolder.itemView.setOnClickListener {
//            val usuario = usuarios[usuarioViewHolder.adapterPosition]
//            usuario.telefone
//        }

        return usuarioViewHolder
    }

    override fun getItemCount(): Int = mensagens.size

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val mensagem = mensagens[position]
        val formatarText = mensagem.usuario?.formatarCartaoPessoal() + "\nSteam: " + mensagem.usuario?.steamId
        holder.campoNome.text = formatarText
        holder.campoStatus.text = mensagem.mensagem
    }
}