package com.example.demo_persistencia

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.System.load

class MainActivity : AppCompatActivity() {

    private lateinit var  etName : EditText
    private lateinit var  etEmail : EditText
    private lateinit var sharedPrefs : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicializa nosso objeto shared
        sharedPrefs = getSharedPreferences("com.satc.exemploprefs",
            Context.MODE_PRIVATE) ?: return

        // pegar referencia das views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)

        findViewById<Button>(R.id.button_shared_prefs).setOnClickListener {
            val it = Intent(this, Shared::class.java)
            startActivity(it)
        }

        findViewById<Button>(R.id.button_sqlite).setOnClickListener {
            val it = Intent(this, SQLITE::class.java)
            startActivity(it)

        }
        findViewById<Button>(R.id.button_save).setOnClickListener {
            save()
        }

    }
        fun load() {
            val loadName = sharedPrefs.getString("KEY_NOME", "Não encontrei o nome")
            etEmail.setText(sharedPrefs.getString("KEY_EMAIL", ""))

            etName.setText(loadName)

            Toast.makeText(this,
                "Dados carregados com Shared",
                Toast . LENGTH_SHORT)
                .show()

        }

        fun save() {
            with(sharedPrefs.edit()){
                putString("KEY_NOME", etName.text.toString())
                putString("KEY_EMAIL", etEmail.text.toString())
                commit()


                Toast.makeText(this,
                    "Salvo com Shared",
                    Toast . LENGTH_SHORT)
                    .show()
            }

        }


    }


    
