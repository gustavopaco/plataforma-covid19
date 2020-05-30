package br.com.cotemig.covid19.ui.adapters
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Switch
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import br.com.cotemig.covid19.R
//import br.com.cotemig.covid19.models.SintomasResponse
//
//class SintomasRecycleAdapter (var context: Context, var list: List<String>)
//    : RecyclerView.Adapter<SintomasRecycleAdapter.ViewSintomas>(){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewSintomas {
//        val view = LayoutInflater.from(context).inflate(R.layout.item_sintomas, parent , false)
//
//
//        return ViewSintomas(view)
//    }
//
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(holder: ViewSintomas, position: Int) {
//            holder.bind(context, list[position])
//
//
//    }
//
//    class ViewSintomas(itemView : View) : RecyclerView.ViewHolder(itemView){
//        fun bind(context: Context, s : String){
//
//            var sintomas = itemView.findViewById<TextView>(R.id.sintomas)
//            sintomas.text = s
//
//        }
//
//    }
//
//}