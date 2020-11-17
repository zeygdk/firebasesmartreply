package com.example.smartreply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage
import kotlinx.android.synthetic.main.item_message_sent.view.*

class MessageAdapter (private val messages: List<FirebaseTextMessage>) :
RecyclerView.Adapter <RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val inflater= LayoutInflater.from(parent.context)
        return SentHolder(inflater.inflate(R.layout.item_message_sent,parent,false))

    }



    override fun getItemCount() = messages.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    holder.itemView.tvSent.text=messages[position].zzmy()
    }

    inner class SentHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
}