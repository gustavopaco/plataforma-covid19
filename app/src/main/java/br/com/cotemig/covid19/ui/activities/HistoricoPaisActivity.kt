package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.CountryHistoricoResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.adapters.HistoricoPaisAdapter
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import kotlinx.android.synthetic.main.activity_historico_pais.*
import kotlinx.android.synthetic.main.item_historicopais.*
import retrofit2.Call
import retrofit2.Response

class HistoricoPaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_pais)

        getHistoricoPais()

        btnvoltar.setOnClickListener {
            finish()
        }

    }

    fun getHistoricoPais() {
        var activity = HomeActivity()
        var s = RetrofitInitializer().serviceHistoricoPais()
        var p = intent.getStringExtra("url")
        var nomepais = intent.getStringExtra("nomepais")
        var call = s.getHistoricoPais(p)

        call.enqueue(object : retrofit2.Callback<List<CountryHistoricoResponse>> {
            override fun onResponse(
                call: Call<List<CountryHistoricoResponse>>?,
                response: Response<List<CountryHistoricoResponse>>?) {

                response?.let {
                    if (it.code() == 200) {
                        historicopais.text = nomepais
                        listahistorico.adapter = HistoricoPaisAdapter(this@HistoricoPaisActivity, it.body())
                        listahistorico.layoutManager = LinearLayoutManager(this@HistoricoPaisActivity,LinearLayoutManager.VERTICAL,false)

                    }else{
                        activity.telaVisivel()
                        MaterialDialog.Builder(this@HistoricoPaisActivity).theme(Theme.LIGHT)
                            .title(R.string.erro)
                            .content(R.string.serviceerror)
                            .positiveText(R.string.ok)
                            .show()
                    }
                }
            }
            override fun onFailure(call: Call<List<CountryHistoricoResponse>>?, t: Throwable?) {
                activity.telaVisivel()
                MaterialDialog.Builder(this@HistoricoPaisActivity).theme(Theme.LIGHT)
                    .title(R.string.erro)
                    .content(R.string.serviceerror)
                    .positiveText(R.string.ok)
                    .show()
            }
        })
    }
}