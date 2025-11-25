package com.natenghub.app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MarketplaceProduceAdapter(private val produceList: List<MarketplaceProduce>) : RecyclerView.Adapter<MarketplaceProduceAdapter.ProduceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_marketplace_produce, parent, false)
        return ProduceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProduceViewHolder, position: Int) {
        val produce = produceList[position]
        holder.produceName.text = produce.name
        holder.farmerName.text = produce.farmerName
        holder.price.text = produce.price
        holder.availableVolume.text = produce.availableVolume
        holder.harvestDate.text = produce.harvestDate
        holder.location.text = produce.location
        holder.verifiedFarmer.visibility = if (produce.isVerified) View.VISIBLE else View.GONE
        // In a real app, you would load the image from the URL here
        holder.produceImage.setImageResource(R.drawable.ic_natenghub_logo) // Placeholder

        if (produce.name == "Fresh Cabbage") {
            holder.negotiateButton.setOnClickListener {
                val intent = Intent(holder.itemView.context, NegotiateActivity::class.java)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = produceList.size

    class ProduceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val produceName: TextView = itemView.findViewById(R.id.tv_produce_name)
        val farmerName: TextView = itemView.findViewById(R.id.tv_farmer_name)
        val price: TextView = itemView.findViewById(R.id.tv_price)
        val availableVolume: TextView = itemView.findViewById(R.id.tv_available_volume)
        val harvestDate: TextView = itemView.findViewById(R.id.tv_harvest_date)
        val location: TextView = itemView.findViewById(R.id.tv_location)
        val verifiedFarmer: TextView = itemView.findViewById(R.id.tv_verified_farmer)
        val produceImage: ImageView = itemView.findViewById(R.id.iv_produce_image)
        val negotiateButton: MaterialButton = itemView.findViewById(R.id.btn_negotiate)
    }
}
