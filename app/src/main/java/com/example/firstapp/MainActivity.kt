package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val inputText:EditText by lazy { findViewById(R.id.inputText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.sendMessage)
        button.setOnClickListener {
            val textView: TextView = findViewById(R.id.getText);
            textView.text =inputText.text;
        }

    }

    fun randomMe(view: View) {
        val randomIntent = Intent(this, MainActivity2::class.java)
        randomIntent.putExtra(MainActivity2.TOTAL_COUNT, 15)
        startActivity(randomIntent)
    }

    fun OnСlickCount(view: View) {
        val textView: TextView = findViewById(R.id.getText);
        val countString = textView.text.toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count++
        // Display the new value in the text view.
        textView.text = count.toString();
    }

    fun OnСlickToastMe(view: View)
    {
        val myToast = Toast.makeText(this, "Пора покормить кота!!!", Toast.LENGTH_LONG)
        myToast.show()
    }

    fun OnСlickSnack(view: View)
    {
        val mySnack = Snackbar.make(view, "Пора покормить кота Snack'ом", Snackbar.LENGTH_LONG)
        mySnack.show()
    }
}