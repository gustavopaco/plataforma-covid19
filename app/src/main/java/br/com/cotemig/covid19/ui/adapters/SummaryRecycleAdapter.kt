package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.Country

class SummaryRecycleAdapter(var context: Context, var list: List<Country>) :
    RecyclerView.Adapter<SummaryRecycleAdapter.ViewSummary>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewSummary {
        val view = LayoutInflater.from(context).inflate(R.layout.item_summary, parent, false)

        return ViewSummary(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewSummary, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewSummary(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, item: Country) {
            var name = itemView.findViewById<TextView>(R.id.country_name)
            var confirmed = itemView.findViewById<TextView>(R.id.total_country_confirmed)

            name.text = item.Country
            confirmed.text = item.TotalConfirmed.toString()

        }
    }
}