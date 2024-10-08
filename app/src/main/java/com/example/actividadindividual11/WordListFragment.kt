package com.example.actividadindividual11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordListFragment : Fragment() {

        private lateinit var wordAdapter: WordAdapter
        private val wordList = mutableListOf<Word>()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

             val view = inflater.inflate(R.layout.fragment_word_list, container, false)

            wordAdapter = WordAdapter(wordList) { word ->
                // Aquí manejamos la selección del item
                wordList[0] = Word("Clicked ${word.text}")
                wordAdapter.notifyItemChanged(0)

                // Navegación al segundo fragmento con el texto seleccionado
                val fragment = WordDetailFragment.newInstance(word.text)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }

            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = wordAdapter

            val addButton = view.findViewById<Button>(R.id.addButton)
            addButton.setOnClickListener {
                val newWord = Word("New Word ${wordList.size + 1}")
                wordAdapter.addWord(newWord)
            }

            return view
        }
    }

