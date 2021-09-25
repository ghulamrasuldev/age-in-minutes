package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener{ view ->
            clickDatePicker(view)
            //Toast.makeText(this, "ButtonWorks!", Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH )
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear is selected", Toast.LENGTH_LONG).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            findViewById<TextView>(R.id.tvSelectedDate).setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val theDateInMinutes = theDate!!.time/60000
            val currentDateInMinutes = sdf.parse(sdf.format(System.currentTimeMillis()))!!.time/60000
            val ageInMinutes = currentDateInMinutes-theDateInMinutes
            findViewById<TextView>(R.id.tvSelectedDateInMinutes).setText(ageInMinutes.toString())
        }, year, month, day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }


}