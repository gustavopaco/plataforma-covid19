package br.com.cotemig.covid19.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.cotemig.covid19.R
import br.com.cotemig.covid19.models.Country

class SummaryAdapter(var context: Context, var list: List<Country>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_summary, null)

        var name = view.findViewById<TextView>(R.id.country_name)
        var confirmed = view.findViewById<TextView>(R.id.total_country_confirmed)

        name.text = list[position].Country
        confirmed.text = list[position].TotalConfirmed.toString()

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