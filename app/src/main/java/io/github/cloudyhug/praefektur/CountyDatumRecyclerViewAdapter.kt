package io.github.cloudyhug.praefektur

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CountyDatumRecyclerViewAdapter(
  private val values: Array<CountyDatum>
) : RecyclerView.Adapter<CountyDatumRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.county_datum_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = values[position]
    holder.numberTextView.text = GameData.frenchCountyToString(item.number)
    holder.countyTextView.text = item.county
    holder.cityTextView.text = item.city
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val numberTextView: TextView = view.findViewById(R.id.number)
    val countyTextView: TextView = view.findViewById(R.id.county)
    val cityTextView: TextView = view.findViewById(R.id.city)
  }
}