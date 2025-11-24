package com.natenghub.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProduceAdapter(private val produceList: List<Produce>) : RecyclerView.Adapter<ProduceAdapter.ProduceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_produce, parent, false)
        return ProduceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProduceViewHolder, position: Int) {
        val produce = produceList[position]
        holder.cropName.text = produce.name
        holder.volume.text = produce.volume
        holder.price.text = produce.price
        holder.status.text = produce.status
        holder.dateListed.text = produce.dateListed
    }

    override fun getItemCount() = produceList.size

    class ProduceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cropName: TextView = itemView.findViewById(R.id.tv_crop_name)
        val volume: TextView = itemView.findViewById(R.id.tv_volume)
        val price: TextView = itemView.findViewById(R.id.tv_price)
        val status: TextView = itemView.findViewById(R.id.tv_status)
        val dateListed: TextView = itemView.findViewById(R.id.tv_date_listed)
    }
}
