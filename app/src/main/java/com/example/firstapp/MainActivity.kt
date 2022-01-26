package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val inputText:EditText by lazy { findViewById(R.id.inputText) }
    lateinit var Observer: Observer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observer= Observer()
        lifecycle.addObserver(Observer)

        val button: Button = findViewById(R.id.sendMessage)
        button.setOnClickListener {
            val textView: TextView = findViewById(R.id.getText);
            textView.text =inputText.text;
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        val textView: TextView = findViewById(R.id.getText);
        outState.run {
            putString("KEY",textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textView: TextView = findViewById(R.id.getText);

        textView.text = savedInstanceState.getString("KEY")
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

    private fun snackMessage(message: String)
    {
        val textView: TextView = findViewById(R.id.getText)
        Snackbar.make(textView, "${lifecycle.currentState}, $message", Snackbar.LENGTH_LONG).show()
    }

    fun OnСlickSnack(view: View)
    {
        snackMessage("Пора покормить кота Snack'ом")
        //val mySnack = Snackbar.make(view, "Пора покормить кота Snack'ом", Snackbar.LENGTH_LONG)
        //mySnack.show()
    }

    override fun onStart(){
        super.onStart()
        snackMessage("On_Start")
    }

}