package com.example.yosep.webservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainInsertActivity : AppCompatActivity() {

    var marca: EditText? = null
    var descripcion:EditText? = null
    var precio:EditText? = null
    var marcaStr: String? = null
    var descripcionStr:String? = null
    var precioStr:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_insert)

        marca = findViewById(R.id.marcaTx)
        descripcion = findViewById(R.id.descripcionTx)
        precio = findViewById(R.id.precioTx)

    }

    fun insert(view: View) {

        marcaStr = marca?.getText().toString()
        descripcionStr = descripcion?.getText().toString()
        precioStr = precio?.getText().toString()

        val method = "register"

        val backgroundTask = BackgroundTask(this)
        backgroundTask.execute(method, marcaStr, descripcionStr, precioStr)
        finish()


    }

    fun volver(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    fun VerInfo(view: View) {

        val intent = Intent(this, MainInfoActivity::class.java)
        startActivity(intent)

    }
}
