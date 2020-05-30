package br.com.cotemig.covid19.ui.adapters
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//import br.com.cotemig.covid19.R
//import br.com.cotemig.covid19.models.NoticiasResponse
//import com.bumptech.glide.Glide
//
//class NoticiasAdapter (var context: Context, var list: List<NoticiasResponse>) : BaseAdapter(){
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var view = LayoutInflater.from(context).inflate(R.layout.item_noticias, null)
//
//        var titulonoticias = view.findViewById<TextView>(R.id.titulonoticias)
//        titulonoticias.text = list[position].titulo
//
//        var datanoticias = view.findViewById<TextView>(R.id.datanoticias)
//        datanoticias.text = list[position].data
//
//        var textonoticias = view.findViewById<TextView>(R.id.textonoticias)
//        textonoticias.text = list[position].noticia
//
//        var imagenoticas = view.findViewById<ImageView>(R.id.imagenoticas)
//
//        Glide.with(context).load(list[position].imagem).into(imagenoticas)
//
//        return view
//    }
//
//    override fun getItem(position: Int): Any {
//        return ""
//    }
//
//    override fun getItemId(position: Int): Long {
//        return 0
//    }
//
//    override fun getCount(): Int {
//        return list.size
//    }
//}