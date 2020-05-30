package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.SintomasResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.adapters.SintomasAdapter
import kotlinx.android.synthetic.main.activity_sintomas.*
import retrofit2.Call
import retrofit2.Response

class SintomasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)

        if(this == this@SintomasActivity){
            btnsintomas.setBackgroundColor(getColor(R.color.red))
            btnsintomas.isClickable = false
        }

        btnnoticias.setOnClickListener {
            var intent = Intent(this, NoticiasActivity::class.java)
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

        getSintomas()

    }


    fun getSintomas() {
        var s = RetrofitInitializer().serviceSintomas()
        var call = s.getSintomas()

        call.enqueue(object : retrofit2.Callback<SintomasResponse> {

            override fun onResponse(
                call: Call<SintomasResponse>?,
                response: Response<SintomasResponse>?
            ) {

                response?.let {
                    if (it.code() == 200) {
                        listageral.adapter = SintomasAdapter(this@SintomasActivity,it.body().sintomascomuns,it.body().sintomasraros,it.body().sintomasgraves,it.body().recomendacoes,it.body().temposintomas)

                    }
                }


            }

            override fun onFailure(call: Call<SintomasResponse>?, t: Throwable?) {
                Toast.makeText(this@SintomasActivity, "Error", Toast.LENGTH_LONG).show()
            }


        })

    }
}