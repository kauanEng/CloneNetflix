package com.kauansantos.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kauansantos.netflixclone.Model.addFilmes
import com.kauansantos.netflixclone.adapter.FilmesAdapter
import com.kauansantos.netflixclone.databinding.ActivityDetalhesFilmesBinding

class DetalhesFilme : AppCompatActivity() {

  private lateinit var binding: ActivityDetalhesFilmesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetalhesFilmesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar!!.hide()
    Toolbar()

    val recycler_outros_filmes = binding.recyclerOutrosFilmes
      recycler_outros_filmes.adapter = FilmesAdapter(addFilmes())

    recycler_outros_filmes.layoutManager = GridLayoutManager(applicationContext, 3)
  }

  private fun Toolbar() {   //ICONE VOLTAR NA TELA
      val toolbar_Detalhes = binding.toolbarDetalhes
      toolbar_Detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
    toolbar_Detalhes.setNavigationOnClickListener{
      val intent = Intent(this, ListaFilmes::class.java)
      startActivity(intent)
      finish()
    }
  }
}