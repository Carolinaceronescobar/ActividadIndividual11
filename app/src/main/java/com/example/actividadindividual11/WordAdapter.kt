package com.example.actividadindividual11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(
    private val words: MutableList<Word>,
    private val onClick: (Word) -> Unit
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordText: TextView = itemView.findViewById(R.id.wordText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.wordText.text = word.text
        holder.itemView.setOnClickListener {
            onClick(word)
        }
    }

    override fun getItemCount(): Int = words.size

    fun addWord(newWord: Word) {
        words.add(newWord)
        notifyItemInserted(words.size - 1)
    }

    fun updateWord(position: Int, newText: String) {
        words[position].text = newText
        notifyItemChanged(position)
    }
}
