package br.com.cotemig.covid19.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.ui.fragment.LocationFragment
import br.com.cotemig.covid19.ui.fragment.NoticiasFragment
import br.com.cotemig.covid19.ui.fragment.SintomasFragment
import br.com.cotemig.covid19.ui.fragment.SummaryFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_location.*

class HomeActivity : AppCompatActivity() {

var numeromenu = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnnoticias.isEnabled = false
        setFragment(NoticiasFragment(),"noticias")
        btnnoticias.setBackgroundColor(getColor(R.color.blueback))
        btnnoticias.setTextColor(getColor(R.color.blueselect))



        btnnoticias.setOnClickListener {
            menu(0)
        }

        btnsintomas.setOnClickListener {
            menu(1)
        }

        btnlocation.setOnClickListener {
            menu(2)
        }

        btnsummary.setOnClickListener {
            menu(3)
        }

    }

    fun setFragment(f: Fragment, name: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.contenthome, f, name)
//        ft.addToBackStack(name)
        ft.commit()

    }

    fun menu (index : Int){
        numeromenu = index

        btnnoticias.setBackgroundColor(getColor(R.color.white))
        btnnoticias.setTextColor(getColor(R.color.grey))

        btnsintomas.setBackgroundColor(getColor(R.color.white))
        btnsintomas.setTextColor(getColor(R.color.grey))

        btnlocation.setBackgroundColor(getColor(R.color.white))
        btnlocation.setTextColor(getColor(R.color.grey))

        btnsummary.setBackgroundColor(getColor(R.color.white))
        btnsummary.setTextColor(getColor(R.color.grey))

        btnnoticias.isClickable = true
        btnsintomas.isClickable = true
        btnlocation.isClickable = true
        btnsummary.isClickable = true
        btnnoticias.isEnabled = true

        if (index == 0){
            btnnoticias.setBackgroundColor(getColor(R.color.blueback))
            btnnoticias.setTextColor(getColor(R.color.blueselect))
            setFragment(NoticiasFragment(),"noticias")
            desligarBotoes()
            loading.visibility = View.VISIBLE
        }else if(index == 1){
            btnsintomas.setBackgroundColor(getColor(R.color.blueback))
            btnsintomas.setTextColor(getColor(R.color.blueselect))
            setFragment(SintomasFragment(),"sintomas")
            desligarBotoes()
            loading.visibility = View.VISIBLE
        }else if(index == 2){
            btnlocation.setBackgroundColor(getColor(R.color.blueback))
            btnlocation.setTextColor(getColor(R.color.blueselect))
            setFragment(LocationFragment(),"location")
            desligarBotoes()
            loading.visibility = View.VISIBLE
        }else if(index == 3){
            btnsummary.setBackgroundColor(getColor(R.color.blueback))
            btnsummary.setTextColor(getColor(R.color.blueselect))
            setFragment(SummaryFragment(),"summary")
            desligarBotoes()
            loading.visibility = View.VISIBLE
        }

    }

    fun telaVisivel(){
        loading.visibility = View.GONE
        btnnoticias.isClickable = true
        btnsintomas.isClickable = true
        btnlocation.isClickable = true
        btnsummary.isClickable = true
    }

    fun desligarBotoes(){
        btnnoticias.isClickable = false
        btnsintomas.isClickable = false
        btnsummary.isClickable = false
        btnlocation.isClickable = false
    }

}