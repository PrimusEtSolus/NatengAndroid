package com.natenghub.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationAdapter(private val notificationList: List<Notification>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_notification, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.title.text = notification.title
        holder.message.text = notification.message
        holder.timestamp.text = notification.timestamp
    }

    override fun getItemCount() = notificationList.size

    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_notification_title)
        val message: TextView = itemView.findViewById(R.id.tv_notification_message)
        val timestamp: TextView = itemView.findViewById(R.id.tv_notification_timestamp)
    }
}
