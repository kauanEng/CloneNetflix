package com.kauansantos.netflixclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kauansantos.netflixclone.Model.Filmes
import com.kauansantos.netflixclone.databinding.ListaFilmesBinding

class FilmesAdapter (val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {



  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {  //PASSAR AO ADAPTADOR O LAYOUT PARA RENDERIZAR
    val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context), parent,false)
      return FilmesViewHolder(binding)
  }

  override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {    //POSIÇÃO DOS ITENS DA LISTA
    with(holder) {
      with(filmes[position]){
        binding.capaFilme.setImageResource(capaFilme)
      }
    }
  }

  override fun getItemCount() = filmes.size   //QUANTIDADE DE ITEMS NA LISTA


  inner class FilmesViewHolder(val binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root) {

  }
}