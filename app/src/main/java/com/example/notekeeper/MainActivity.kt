package com.example.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var notePosition = PositionNotSet
    private var action : String = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter<CourseInfo>(this,
            android.R.layout.simple_spinner_item, DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(NotePosition, PositionNotSet)

        if (notePosition != PositionNotSet)
            displayNote()
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        noteTitleEt.setText(note.title)
        noteTextEt.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        spinnerCourses.setSelection(coursePosition)
        invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_settings -> true
            R.id.action_next -> {
                action = "next"
                moveToNote()
                true
            }
            R.id.action_previous -> {
                action = "previous"
                moveToNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveToNote() {
        when (action){
            "next" -> ++notePosition
            "previous" -> --notePosition
        }
        displayNote()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val menuItem = when (notePosition){
            DataManager.notes.lastIndex ->  menu?.findItem(R.id.action_next)
                0 ->  menu?.findItem(R.id.action_previous)
            else -> null
        }
        if (menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block)
                menuItem.isEnabled = false
            }

        return super.onPrepareOptionsMenu(menu)
    }
}