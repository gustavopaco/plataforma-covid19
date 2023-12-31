package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import br.com.cotemig.covid19.R

class SintomasAdapter (var context: Context, var list: List<String>, var list2 : List<String>, var list3 : List<String>, var list4 : List<String>, var s : String) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_sintomas,null)
        var listasintomas = view.findViewById<ListView>(R.id.listasintomas)
        var listasinatomasraros = view.findViewById<ListView>(R.id.listasinatomasraros)
        var listasinatomasgraves = view.findViewById<ListView>(R.id.listasinatomasgraves)
        var listarecomendacoes = view.findViewById<ListView>(R.id.listarecomendacoes)
        var temposintomas = view.findViewById<TextView>(R.id.temposintomas)


        listasintomas.adapter = SintomasItemAdapter(context,list)
        listasinatomasraros.adapter = SintomasItemAdapter(context,list2)
        listasinatomasgraves.adapter = SintomasItemAdapter(context,list3)
        listarecomendacoes.adapter = SintomasItemAdapter(context,list4)
        temposintomas.text = s


    return view
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {

        return 1
    }
}