package com.example.smartreply

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_suggestion.view.*

class SuggestionAdapter (private val suggestions: List<String>):
RecyclerView.Adapter<SuggestionAdapter.SuggestionHolder>()
{
    inner class SuggestionHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionHolder  {
        return SuggestionHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_suggestion, parent, false)
        )

    }


    override fun getItemCount() = suggestions.size
    override fun onBindViewHolder(holder: SuggestionHolder, position: Int) {
        holder.itemView.tvsuggestion.text =suggestions[position]

    }
}