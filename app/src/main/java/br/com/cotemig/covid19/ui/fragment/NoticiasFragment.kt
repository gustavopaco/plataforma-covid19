package br.com.cotemig.covid19.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.NoticiasResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.activities.HomeActivity
import br.com.cotemig.covid19.ui.adapters.NoticiasRecycleAdapter
import kotlinx.android.synthetic.main.fragment_noticias.*
import retrofit2.Call
import retrofit2.Response


class NoticiasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_noticias, container, false)

        getNoticias()

        return view
    }

    fun getNoticias(){
        var activity = context as HomeActivity
        var s = RetrofitInitializer().serviceNoticias()
        var call = s.getNoticias()

        call.enqueue(object : retrofit2.Callback<List<NoticiasResponse>>{

            override fun onResponse(
                call: Call<List<NoticiasResponse>>?,
                response: Response<List<NoticiasResponse>>?
            ) {

                response?.let {
                    if(it.code() == 200){

                        listarecynoticias.adapter = NoticiasRecycleAdapter(activity,it.body())
                        listarecynoticias.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

//                        Toast.makeText(this@NoticiasActivity,"Ok",Toast.LENGTH_LONG).show()
                    }
                }

            }

            override fun onFailure(call: Call<List<NoticiasResponse>>?, t: Throwable?) {
                Toast.makeText(activity,"Error", Toast.LENGTH_LONG).show()
            }
        })

    }

}