package com.natenghub.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val transactionList: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactionList[position]
        holder.orderId.text = transaction.orderId
        holder.date.text = transaction.date
        holder.total.text = transaction.total
        holder.status.text = transaction.status
    }

    override fun getItemCount() = transactionList.size

    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.tv_order_id)
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val total: TextView = itemView.findViewById(R.id.tv_total)
        val status: TextView = itemView.findViewById(R.id.tv_status)
    }
}
