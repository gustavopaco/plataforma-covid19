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
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        desabilitarBotoes()
        btnnoticias.setBackgroundColor(getColor(R.color.blueback))
        btnnoticias.setTextColor(getColor(R.color.blueselect))
        setFragment(NoticiasFragment(),"noticias")


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

    // Funcao que detecta baseado no indice, qual botao foi clicado e chama o servico
    fun menu (index : Int){

        btnnoticias.setBackgroundColor(getColor(R.color.white))
        btnnoticias.setTextColor(getColor(R.color.grey))

        btnsintomas.setBackgroundColor(getColor(R.color.white))
        btnsintomas.setTextColor(getColor(R.color.grey))

        btnlocation.setBackgroundColor(getColor(R.color.white))
        btnlocation.setTextColor(getColor(R.color.grey))

        btnsummary.setBackgroundColor(getColor(R.color.white))
        btnsummary.setTextColor(getColor(R.color.grey))

        desligarBotoes()
        loading.visibility = View.VISIBLE
        loadingbar.visibility = View.VISIBLE

        if (index == 0){
            btnnoticias.setBackgroundColor(getColor(R.color.blueback))
            btnnoticias.setTextColor(getColor(R.color.blueselect))
            setFragment(NoticiasFragment(),"noticias")
        }else if(index == 1){
            btnsintomas.setBackgroundColor(getColor(R.color.blueback))
            btnsintomas.setTextColor(getColor(R.color.blueselect))
            setFragment(SintomasFragment(),"sintomas")
        }else if(index == 2){
            btnlocation.setBackgroundColor(getColor(R.color.blueback))
            btnlocation.setTextColor(getColor(R.color.blueselect))
            setFragment(LocationFragment(),"location")
        }else if(index == 3){
            btnsummary.setBackgroundColor(getColor(R.color.blueback))
            btnsummary.setTextColor(getColor(R.color.blueselect))
            setFragment(SummaryFragment(),"summary")
        }

    }

    // Remove Loading da tela e abilita os botoes
    fun telaVisivel(){
        loading.visibility = View.GONE
        loadingbar.visibility = View.GONE
        btnnoticias.isEnabled = true
        btnsintomas.isEnabled = true
        btnlocation.isEnabled = true
        btnsummary.isEnabled = true

        btnnoticias.isClickable = true
        btnsintomas.isClickable = true
        btnlocation.isClickable = true
        btnsummary.isClickable = true
    }

    // Desabilita os botoes somente na primeira vez que abre o aplicativo
    fun desligarBotoes(){
        btnnoticias.isClickable = false
        btnsintomas.isClickable = false
        btnlocation.isClickable = false
        btnsummary.isClickable = false
    }

    // Desabilita os botoes somente ao abrir o APP para nao forcar bug no servico
    fun desabilitarBotoes(){
        btnnoticias.isEnabled = false
        btnsintomas.isEnabled = false
        btnlocation.isEnabled = false
        btnsummary.isEnabled = false
    }

}