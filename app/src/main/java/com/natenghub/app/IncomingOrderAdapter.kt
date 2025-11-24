package com.natenghub.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IncomingOrderAdapter(private val orderList: List<IncomingOrder>) : RecyclerView.Adapter<IncomingOrderAdapter.IncomingOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomingOrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_incoming_order, parent, false)
        return IncomingOrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: IncomingOrderViewHolder, position: Int) {
        val order = orderList[position]
        holder.orderId.text = order.orderId
        holder.items.text = order.items
        holder.date.text = order.date
        holder.status.text = order.status
    }

    override fun getItemCount() = orderList.size

    class IncomingOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.tv_order_id)
        val items: TextView = itemView.findViewById(R.id.tv_items)
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val status: TextView = itemView.findViewById(R.id.tv_status)
    }
}
