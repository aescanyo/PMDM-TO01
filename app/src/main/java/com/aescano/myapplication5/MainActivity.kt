package com.aescano.myapplication5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Listener del botón
        val boton = findViewById<Button>(R.id.boton)
        boton.setOnClickListener {
            // Obtener el número del cuadro de texto
            val numero = findViewById<EditText>(R.id.numero).text.toString()

            // Validar que el número sea un entero positivo
            try {
                val numeroEntero = numero.toInt()
                if (numeroEntero < 1) {
                    throw IllegalArgumentException("El número debe ser un entero positivo")
                }

                // Obtener los divisores del número
                val divisores = mutableListOf<Int>()
                for (i in 1 until numeroEntero + 1) {
                    if (numeroEntero % i == 0) {
                        divisores.add(i)
                    }
                }

                // Mostrar los divisores en la etiqueta
                val divisoresTexto = divisores.joinToString(", ")
                findViewById<TextView>(R.id.divisores).text = divisoresTexto
            } catch (e: NumberFormatException) {
                // Mostrar un mensaje de error
                findViewById<TextView>(R.id.divisores).text = "El número introducido no es válido"
            } catch (e: IllegalArgumentException) {
                // Mostrar un mensaje de error
                findViewById<TextView>(R.id.divisores).text = e.message
            }
        }
    }
}