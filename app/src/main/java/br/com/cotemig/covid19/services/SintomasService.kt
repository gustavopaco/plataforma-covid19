package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.SintomasResponse
import retrofit2.Call
import retrofit2.http.GET

interface SintomasService {

    @GET("sintomas")
    fun getSintomas() : Call<SintomasResponse>

}