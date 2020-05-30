package br.com.cotemig.covid19.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    companion object {
        private val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                    chain.proceed(newRequest.build())
                }
                .addInterceptor(HttpLoggingInterceptor().also { it ->
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
        }

    }


    private val retrofitSintomasNoticias = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://5ec8a6ec155c130016a90c84.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val retrofitCasosEstados = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://covid19-brazil-api.now.sh/api/report/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitLocationbyIP = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://ip-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitSummary = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.covid19api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceSintomas(): SintomasService {
        return retrofitSintomasNoticias.create(SintomasService::class.java)
    }

    fun serviceNoticias(): NoticiasService {
        return retrofitSintomasNoticias.create(NoticiasService::class.java)
    }

    fun serviceCasosEstados(): CasosDataService {
        return retrofitCasosEstados.create(CasosDataService::class.java)
    }

    fun serviceLocationbyIP(): LocationbyIPService {
        return retrofitLocationbyIP.create(LocationbyIPService::class.java)
    }

    fun serviceSummary() : SummaryService {
        return retrofitSummary.create(SummaryService::class.java)
    }

}