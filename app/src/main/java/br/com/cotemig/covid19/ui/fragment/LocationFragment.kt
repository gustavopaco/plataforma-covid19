package br.com.cotemig.covid19.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.CasosDataResponse
import br.com.cotemig.covid19.models.LocationbyIPResponse
import br.com.cotemig.covid19.services.RetrofitInitializer
import br.com.cotemig.covid19.ui.activities.HomeActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import kotlinx.android.synthetic.main.fragment_location.*
import retrofit2.Call
import retrofit2.Response

class LocationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_location, container, false)

        getLocationbyIP()

        return view
    }

    fun getLocationbyIP() {
        var activity = context as HomeActivity
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
                    }else {
                        activity.telaVisivel()
                        MaterialDialog.Builder(activity).theme(Theme.LIGHT)
                            .title(R.string.erro)
                            .content(R.string.locationerror)
                            .positiveText(R.string.ok)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<LocationbyIPResponse>?, t: Throwable?) {
                activity.telaVisivel()
                MaterialDialog.Builder(activity).theme(Theme.LIGHT)
                    .title(R.string.erro)
                    .content(R.string.serviceerror)
                    .positiveText(R.string.ok)
                    .show()
            }

        })
    }

    fun getCasosEstados(siglaEstado : String){
        var activity = context as HomeActivity
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
                                activity.telaVisivel()
                            }
                        }
//                        Toast.makeText(this@CasosEstadosActivity,"Ok", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<CasosDataResponse>?, t: Throwable?) {
                Toast.makeText(context as HomeActivity,"Error", Toast.LENGTH_LONG).show()
            }


        })

    }

}