package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.CountryHistoricoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HistoricoPaisService {
    @GET("dayone/country/{id}")
    fun getHistoricoPais(
        @Path("id") id: String
    ) : Call<List<CountryHistoricoResponse>>

}