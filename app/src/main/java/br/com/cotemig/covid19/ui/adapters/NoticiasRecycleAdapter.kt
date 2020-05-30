package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.NoticiasResponse
import com.bumptech.glide.Glide

class NoticiasRecycleAdapter (var context: Context, var list: List<NoticiasResponse>) : RecyclerView.Adapter<NoticiasRecycleAdapter.ViewNoticias>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewNoticias {
        val view = LayoutInflater.from(context).inflate(R.layout.item_noticias, parent,false)

        return ViewNoticias(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewNoticias, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewNoticias(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind (context: Context, item : NoticiasResponse){

            var titulonoticias = itemView.findViewById<TextView>(R.id.titulonoticias)
            var datanoticias = itemView.findViewById<TextView>(R.id.datanoticias)
            var textonoticias = itemView.findViewById<TextView>(R.id.textonoticias)
            var imagenoticas = itemView.findViewById<ImageView>(R.id.imagenoticas)


            titulonoticias.text = item.titulo
            datanoticias.text = item.data
            textonoticias.text = item.noticia

            Glide.with(context).load(item.imagem).into(imagenoticas)

        }

    }
}