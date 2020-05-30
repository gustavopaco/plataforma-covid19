package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.NoticiasResponse
import retrofit2.Call
import retrofit2.http.GET

interface NoticiasService{

    @GET("ultimasnoticias")
    fun getNoticias() : Call<List<NoticiasResponse>>

}