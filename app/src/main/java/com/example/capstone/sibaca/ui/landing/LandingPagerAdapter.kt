package com.example.capstone.sibaca.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.sibaca.R

class LandingPagerAdapter (private val descriptions: Array<String>) :
    RecyclerView.Adapter<LandingPagerAdapter.LandingViewHolder>() {

    inner class LandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandingViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_landing, parent, false)
        return LandingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LandingViewHolder, position: Int) {
        val description = descriptions[position]
        holder.descriptionTextView.text = description
    }

    override fun getItemCount(): Int {
        return descriptions.size
    }
}