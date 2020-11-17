package com.example.smartreply

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage
import kotlinx.android.synthetic.main.activity_main.*

//adapter needed

class MainActivity : AppCompatActivity() {

    private val messages = arrayListOf<FirebaseTextMessage>()
    private val messageAdapter = MessageAdapter(messages)
    private val suggestions = arrayListOf<String>()
    private val suggestionAdapter = SuggestionAdapter(suggestions)
    private val smartReply = FirebaseNaturalLanguage.getInstance().smartReply




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMessages.layoutManager=LinearLayoutManager(this)
        rvMessages.adapter=messageAdapter
        rvsuggestions.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        rvsuggestions.adapter=suggestionAdapter
        floatingActionButton.setOnClickListener{
            val message= FirebaseTextMessage.createForRemoteUser(
                editText.text.toString(),
                System.currentTimeMillis(),
                "uid_of_friend"

            )
            messages.add(message)
            messageAdapter.notifyItemInserted(messages.size)
            rvMessages.scrollToPosition(messages.size-1)
            editText.setText("")

            smartReply.suggestReplies(
            messages.takeLast(2)

            )
                .addOnSuccessListener {
                    suggestions.clear()
                    it.suggestions.forEach{
                        suggestions.add(it.text)
                    }
                    suggestionAdapter.notifyDataSetChanged()
                }
                .addOnFailureListener{
                    it.printStackTrace()
                }
        }
    }
}