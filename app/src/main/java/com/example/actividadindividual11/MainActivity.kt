package com.example.actividadindividual11

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadindividual11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var wordAdapter: WordAdapter
    private val wordList = mutableListOf<Word>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordAdapter = WordAdapter(wordList) { word ->
            // Aquí manejamos la selección del item
            wordList[0] = Word("Clicked ${word.text}")
            wordAdapter.notifyItemChanged(0)

            // Navegación al segundo fragmento con el texto seleccionado
            val fragment = WordDetailFragment.newInstance(word.text)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = wordAdapter

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val newWord = Word("New Word ${wordList.size + 1}")
            wordAdapter.addWord(newWord)
        }
    }
}
