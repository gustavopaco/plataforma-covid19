package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.CasosDataResponse
import retrofit2.Call
import retrofit2.http.GET

interface CasosDataService {

    @GET("v1")
    fun getCasosEstados() : Call<CasosDataResponse>

}