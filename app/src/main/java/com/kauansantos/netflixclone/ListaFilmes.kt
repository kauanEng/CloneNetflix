package com.kauansantos.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.kauansantos.netflixclone.Model.addFilmes
import com.kauansantos.netflixclone.adapter.FilmesAdapter
import com.kauansantos.netflixclone.databinding.ActivityListaFilmesBinding

class ListaFilmes : AppCompatActivity() {

  private lateinit var binding: ActivityListaFilmesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityListaFilmesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val recycler_filmes = binding.recyclerview    //adaptando ao modelos de dados
    recycler_filmes.adapter = FilmesAdapter(addFilmes())
    recycler_filmes.layoutManager = GridLayoutManager(applicationContext, 3)
  }

  // : MENU DESLOGAR DA PAGINA FILMES

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {   //botão direito generate - ESTE AQUI
    val inflate = menuInflater
    inflate.inflate(R.menu.menu_principal, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {  //botão direito generate - ESTE AQUI

    when (item.itemId) {
      R.id.deslogar -> {
        FirebaseAuth.getInstance().signOut()
        voltarTelaLogin()
      }
    }
    return super.onOptionsItemSelected(item)
  }

  private fun voltarTelaLogin() {
    val intent = Intent(this, FormLogin::class.java)
    startActivity(intent)
    finish()
  }
}