package com.paufont.calculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var pantalla: TextView
    lateinit var textPantalla: String
    lateinit var valueOfOldScreen: String
    lateinit var operation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pantalla = findViewById<TextView>(R.id.Pantalla)
        textPantalla = pantalla.text.toString()
        valueOfOldScreen = ""
    }

    fun onClick(view: View) {
        var value = view.tag.toString()
        textPantalla += value
        pantalla.text = textPantalla
    }

    fun onClickC(view: View) {
        if (textPantalla != ""){
            var textPantallaBorrat = textPantalla.dropLast(1)
            pantalla.text = textPantallaBorrat
            textPantalla = textPantallaBorrat
        }
    }

    fun operation(view: View) {
        borrarPantalla(view)
    }

    fun borrarPantalla(view: View) {
        valueOfOldScreen = textPantalla
        pantalla.text = ""
        textPantalla = ""
        operation = view.tag.toString()
    }

    fun calculate(view: View) {
        when (operation) {
            "+" -> {
                val result = valueOfOldScreen.toFloat() + textPantalla.toFloat()
                pantalla.text = result.toString()
                textPantalla = result.toString()
            }

            "-" -> {
                val result = valueOfOldScreen.toFloat() - textPantalla.toFloat()
                pantalla.text = result.toString()
                textPantalla = result.toString()
            }

            "*" -> {
                val result = valueOfOldScreen.toFloat() * textPantalla.toFloat()
                pantalla.text = result.toString()
                textPantalla = result.toString()
            }

            "/" -> {
                if (textPantalla == "0") {
                    pantalla.text = "Error"
                    textPantalla = ""
                } else {
                    val result = valueOfOldScreen.toFloat() / textPantalla.toFloat()
                    pantalla.text = result.toString()
                    textPantalla = result.toString()
                }
            }

        }
    }
}