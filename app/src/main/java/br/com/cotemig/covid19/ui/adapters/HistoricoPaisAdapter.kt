package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.CountryHistoricoResponse
import java.text.SimpleDateFormat

class HistoricoPaisAdapter(var context: Context, var list: List<CountryHistoricoResponse>) :
    RecyclerView.Adapter<HistoricoPaisAdapter.ViewHistoricoPais>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHistoricoPais {
        var view = LayoutInflater.from(context).inflate(R.layout.item_historicopais, parent, false)

        return ViewHistoricoPais(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHistoricoPais, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewHistoricoPais(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, item: CountryHistoricoResponse) {
//            var Country = itemView.findViewById<TextView>(R.id.Country)
            var data = itemView.findViewById<TextView>(R.id.data)
            var Confirmed = itemView.findViewById<TextView>(R.id.Confirmed)
            var Deaths = itemView.findViewById<TextView>(R.id.Deaths)
            var Active = itemView.findViewById<TextView>(R.id.Active)
            var Recovered = itemView.findViewById<TextView>(R.id.Recovered)

            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val output: String = formatter.format(parser.parse(item.Date.toString()))

//            Country.text = item.Country
            data.text = output
            Confirmed.text = item.Confirmed.toString()
            Deaths.text = item.Deaths.toString()
            Active.text = item.Active.toString()
            Recovered.text = item.Recovered.toString()


        }
    }
}