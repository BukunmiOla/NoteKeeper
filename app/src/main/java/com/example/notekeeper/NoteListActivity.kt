package com.example.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val gotToEditNote = Intent(this, MainActivity::class.java)
            startActivity(gotToEditNote)
        }
        noteList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataManager.notes)

        noteList.setOnItemClickListener { parent, view, position, id ->
            val activityIntent = Intent (this,MainActivity::class.java)
            activityIntent.putExtra(NotePosition,position)
            startActivity(activityIntent)
        }
    }

    override fun onResume() {

        super.onResume()
        (noteList.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}