package com.example.actividadindividual11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class WordDetailFragment : Fragment() {

    private var wordText: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word_detail, container, false)

        wordText = arguments?.getString("wordText")

        val editText = view.findViewById<EditText>(R.id.editWordText)
        val saveButton = view.findViewById<Button>(R.id.saveButton)

        editText.setText(wordText)

        saveButton.setOnClickListener {
            val newWordText = editText.text.toString()
            val activity = activity as MainActivity
            activity.wordAdapter.updateWord(0, newWordText)  // Actualiza la palabra en la lista
            activity.supportFragmentManager.popBackStack()  // Vuelve al fragmento anterior
        }

        return view
    }

    companion object {
        fun newInstance(wordText: String) =
            WordDetailFragment().apply {
                arguments = Bundle().apply {
                    putString("wordText", wordText)
                }
            }
    }
}
