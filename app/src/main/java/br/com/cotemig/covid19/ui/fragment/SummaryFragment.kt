package br.com.cotemig.covid19.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.Summary
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.activities.HistoricoPaisActivity
import br.com.cotemig.covid19.ui.activities.HomeActivity
import br.com.cotemig.covid19.ui.adapters.SummaryRecycleAdapter
import br.com.cotemig.covid19.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_summary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_summary, container, false)

        getSummary()

        return view
    }

    private fun getSummary() {
        var activity = context as HomeActivity
        var s = RetrofitInitializer().serviceSummary()
        var call = s.getSummary()

        call.enqueue(object : Callback<Summary> {
            override fun onResponse(call: Call<Summary>?, response: Response<Summary>?) {
                response?.let {
                    if (it.code() == 200) {
                        total_confirmed.text = it.body().Global.TotalConfirmed.toString()
                        total_actual.text = (it.body().Global.TotalConfirmed - it.body().Global.TotalDeaths - it.body().Global.TotalRecovered).toString()
                        new_recovered.text = it.body().Global.NewRecovered.toString()
                        total_recovered.text = it.body().Global.TotalRecovered.toString()
                        new_deaths.text = it.body().Global.NewDeaths.toString()
                        total_deaths.text = it.body().Global.TotalDeaths.toString()

                        listacountries.adapter =SummaryRecycleAdapter(context as HomeActivity, it.body().Countries)
                        listacountries.layoutManager = LinearLayoutManager(context as HomeActivity,LinearLayoutManager.VERTICAL,false)
                        getRecycleItemClickListener(it.body())
                        activity.telaVisivel()
                    }
                }
            }

            override fun onFailure(call: Call<Summary>?, t: Throwable?) {
                Toast.makeText(context as HomeActivity, "ERROR!!", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getRecycleItemClickListener(pais : Summary) {
//        val recyclerView = findViewById<RecyclerView>(R.id.listacountries)
        listacountries.addOnItemTouchListener(RecyclerItemClickListener(context as HomeActivity,listacountries,object : RecyclerItemClickListener.OnItemClickListener {
                    override
                    fun onItemClick(view: View?, position: Int) {
                        var intent = Intent(context as HomeActivity, HistoricoPaisActivity::class.java)
                        intent.putExtra("pais", pais.Countries[position].Slug)
                        intent.putExtra("nomepais", pais.Countries[position].Country)
                        startActivity(intent)
//                        Toast.makeText(this@SummaryActivity,"Cliquei no pais\n".plus(pais.Countries[position].Slug),Toast.LENGTH_LONG).show()
                    }
                    override
                    fun onLongItemClick(view: View?, position: Int) {
                        // do whatever
                    }
                }))
    }

}