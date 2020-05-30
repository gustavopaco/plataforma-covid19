package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.cotemig.covid19.R

class SintomasItemAdapter (var context: Context, var list : List<String>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_sintomas2,null)
        var sintomas2 = view.findViewById<TextView>(R.id.sintomas2)
        sintomas2.text = list[position]


//        var listasintomas = view.findViewById<ListView>(R.id.listasintomas)
//        var listasinatomasraros = view.findViewById<ListView>(R.id.listasinatomasraros)
//        var listasinatomasgraves = view.findViewById<ListView>(R.id.listasinatomasgraves)
//        var listarecomendacoes = view.findViewById<ListView>(R.id.listarecomendacoes)

//        listasintomas.adapter = SintomasAdapter(context, list)
//        listasinatomasraros.adapter = SintomasAdapter(context,list2)
//        listasinatomasgraves.adapter = SintomasAdapter(context,list3)

        return view
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}