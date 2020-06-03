package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.Summary
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.adapters.SummaryRecycleAdapter
import br.com.cotemig.covid19.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_summary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        if (this == this@SummaryActivity) {
            btnsummary.setBackgroundColor(getColor(R.color.blueback))
            btnsummary.setTextColor(getColor(R.color.blueselect))
            btnsummary.isClickable = false
        }

        btnnoticias.setOnClickListener {
            var intent = Intent(this, NoticiasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnsintomas.setOnClickListener {
            var intent = Intent(this, SintomasActivity::class.java)
            startActivity(intent)
            finish()
        }

        btncasos.setOnClickListener {
            var intent = Intent(this, CasosEstadosActivity::class.java)
            startActivity(intent)
            finish()
        }

        getSummary()



    }

    private fun getSummary() {
        var s = RetrofitInitializer().serviceSummary()
        var call = s.getSummary()

        call.enqueue(object : Callback<Summary> {
            override fun onResponse(call: Call<Summary>?, response: Response<Summary>?) {
                response?.let {
                    if (it.code() == 200) {
                        total_confirmed.text = it.body().Global.TotalConfirmed.toString()
                        total_actual.text =
                            (it.body().Global.TotalConfirmed - it.body().Global.TotalDeaths - it.body().Global.TotalRecovered).toString()
                        new_recovered.text = it.body().Global.NewRecovered.toString()
                        total_recovered.text = it.body().Global.TotalRecovered.toString()
                        new_deaths.text = it.body().Global.NewDeaths.toString()
                        total_deaths.text = it.body().Global.TotalDeaths.toString()

                        listacountries.adapter =
                            SummaryRecycleAdapter(this@SummaryActivity, it.body().Countries)
                        listacountries.layoutManager = LinearLayoutManager(
                            this@SummaryActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        getRecycleItemClickListener(it.body())
//                        countriesList.adapter = SummaryAdapter(this@SummaryActivity, it.body().Countries)
                    }
                }
            }

            override fun onFailure(call: Call<Summary>?, t: Throwable?) {
                Toast.makeText(this@SummaryActivity, "ERROR!!", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getRecycleItemClickListener(pais : Summary) {
        val recyclerView = findViewById<RecyclerView>(R.id.listacountries)
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                this,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override
                    fun onItemClick(view: View?, position: Int) {
                        var intent = Intent(this@SummaryActivity,HistoricoPaisActivity::class.java)
                        intent.putExtra("pais", pais.Countries[position].Slug)
                        startActivity(intent)
                        finish()
//                        Toast.makeText(this@SummaryActivity,"Cliquei no pais\n".plus(pais.Countries[position].Slug),Toast.LENGTH_LONG).show()
                    }
                    override
                    fun onLongItemClick(view: View?, position: Int) {
                        // do whatever
                    }
                })
        )
    }

}