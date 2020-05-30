package br.com.cotemig.covid19.services

import br.com.cotemig.covid19.models.Summary
import retrofit2.Call
import retrofit2.http.GET

interface SummaryService {

    @GET("summary")
    fun getSummary() : Call<Summary>
}