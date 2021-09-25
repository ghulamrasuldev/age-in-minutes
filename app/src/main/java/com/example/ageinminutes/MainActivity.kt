package com.example.ageinminutes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnDatePicker)
        button.setOnClickListener{
            val simpleCalendarView =
                findViewById<View>(R.id.simpleCalendarView) as CalendarView // get the reference of CalendarView
            val selectedDate = simpleCalendarView.date

        }
    }
}