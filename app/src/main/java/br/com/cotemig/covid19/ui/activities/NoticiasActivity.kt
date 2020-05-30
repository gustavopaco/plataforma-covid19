package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.NoticiasResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.adapters.NoticiasRecycleAdapter
import kotlinx.android.synthetic.main.activity_noticias.*
import retrofit2.Call
import retrofit2.Response

class NoticiasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)



        if(this == this@NoticiasActivity){
            btnnoticias.setBackgroundColor(getColor(R.color.red))
            btnnoticias.isClickable = false
        }

        btnsintomas.setOnClickListener {
            var intent = Intent(this,SintomasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btncasos.setOnClickListener {
            var intent = Intent(this,CasosEstadosActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnsummary.setOnClickListener {
            var intent = Intent(this,SummaryActivity::class.java)
            startActivity(intent)
            finish()
        }

        getNoticias()

    }

    fun getNoticias(){

        var s = RetrofitInitializer().serviceNoticias()
        var call = s.getNoticias()

        call.enqueue(object : retrofit2.Callback<List<NoticiasResponse>>{

            override fun onResponse(
                call: Call<List<NoticiasResponse>>?,
                response: Response<List<NoticiasResponse>>?
            ) {

                response?.let {
                    if(it.code() == 200){

                        listarecynoticias.adapter = NoticiasRecycleAdapter(this@NoticiasActivity,it.body())
                        listarecynoticias.layoutManager = LinearLayoutManager(this@NoticiasActivity,LinearLayoutManager.VERTICAL,false)

//                        val snapHelper = PagerSnapHelper()
//                        snapHelper.attachToRecyclerView(listarecynoticias)


//                        listanoticias.adapter = NoticiasAdapter(this@NoticiasActivity,it.body())
//                        Toast.makeText(this@NoticiasActivity,"Ok",Toast.LENGTH_LONG).show()
                    }
                }

            }

            override fun onFailure(call: Call<List<NoticiasResponse>>?, t: Throwable?) {
                Toast.makeText(this@NoticiasActivity,"Error",Toast.LENGTH_LONG).show()
            }


        })

    }
}