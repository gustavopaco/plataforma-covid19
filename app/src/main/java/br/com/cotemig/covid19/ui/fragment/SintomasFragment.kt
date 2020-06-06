package br.com.cotemig.covid19.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.SintomasResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.activities.HomeActivity
import br.com.cotemig.covid19.ui.adapters.SintomasAdapter
import kotlinx.android.synthetic.main.fragment_sintomas.*
import retrofit2.Call
import retrofit2.Response

class SintomasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sintomas, container, false)

        getSintomas()

        return view
    }

    fun getSintomas() {
        var activity = context as HomeActivity
        var s = RetrofitInitializer().serviceSintomas()
        var call = s.getSintomas()

        call.enqueue(object : retrofit2.Callback<SintomasResponse> {

            override fun onResponse(
                call: Call<SintomasResponse>?,
                response: Response<SintomasResponse>?
            ) {
                response?.let {
                    if (it.code() == 200) {
                        listageral.adapter = SintomasAdapter(activity,it.body().sintomascomuns,it.body().sintomasraros,it.body().sintomasgraves,it.body().recomendacoes,it.body().temposintomas)

                    }
                }
            }

            override fun onFailure(call: Call<SintomasResponse>?, t: Throwable?) {
                Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
            }
        })

    }

}