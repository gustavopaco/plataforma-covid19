package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.LocationbyIPResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationbyIPService {

    @GET("json/")
    fun getLocationbyIP() : Call<LocationbyIPResponse>

}