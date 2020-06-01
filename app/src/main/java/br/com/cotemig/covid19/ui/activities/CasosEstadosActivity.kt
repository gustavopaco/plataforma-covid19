package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.CasosDataResponse
import br.com.cotemig.covid19.models.LocationbyIPResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_casos_estados.*
import kotlinx.android.synthetic.main.activity_casos_estados.btncasos
import kotlinx.android.synthetic.main.activity_casos_estados.btnnoticias
import kotlinx.android.synthetic.main.activity_casos_estados.btnsintomas
import retrofit2.Call
import retrofit2.Response

class CasosEstadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_casos_estados)

        if(this == this@CasosEstadosActivity){
            btncasos.setBackgroundColor(getColor(R.color.blueback))
            btncasos.setTextColor(getColor(R.color.blueselect))
            btncasos.isClickable = false
        }

        btnnoticias.setOnClickListener {
            var intent = Intent(this, NoticiasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnsintomas.setOnClickListener {
            var intent = Intent (this, SintomasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnsummary.setOnClickListener {
            var intent = Intent (this, SummaryActivity::class.java)
            startActivity(intent)
            finish()
        }

        getLocationbyIP()
    }

    fun getLocationbyIP() {

        var s = RetrofitInitializer().serviceLocationbyIP()
        var call = s.getLocationbyIP()

        call.enqueue(object : retrofit2.Callback<LocationbyIPResponse>{

            override fun onResponse(
                call: Call<LocationbyIPResponse>?,
                response: Response<LocationbyIPResponse>?
            ) {
                response?.let {
                    if(it.code() == 200){
                        getCasosEstados(it.body().region)
//                        Toast.makeText(this@CasosEstadosActivity,"Ok", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<LocationbyIPResponse>?, t: Throwable?) {
                Toast.makeText(this@CasosEstadosActivity,"Error", Toast.LENGTH_LONG).show()
            }

        })

    }

    fun getCasosEstados(siglaEstado : String){

        var s = RetrofitInitializer().serviceCasosEstados()
        var call = s.getCasosEstados()

        call.enqueue(object : retrofit2.Callback<CasosDataResponse>{
            override fun onResponse(
                call: Call<CasosDataResponse>?,
                response: Response<CasosDataResponse>?
            ) {
                response?.let {
                    if(it.code() == 200){
                            for(i in it.body().data){
                               if(i.uf.equals(siglaEstado)){
                                   uf.text = i.uf
                                   estado.text = i.state
                                   casos.text = i.cases.toString()
                                   deaths.text = i.deaths.toString()
                                   suspects.text = i.suspects.toString()
                                   refuses.text = i.refuses.toString()
                               }
                            }
//                        Toast.makeText(this@CasosEstadosActivity,"Ok", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<CasosDataResponse>?, t: Throwable?) {
                Toast.makeText(this@CasosEstadosActivity,"Error", Toast.LENGTH_LONG).show()
            }


        })

    }

}