package com.example.yosep.webservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainDeleteActivity : AppCompatActivity() {

    var marca: EditText? = null
    var marcaStr: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_delete)

        marca = findViewById(R.id.marcaTx)

    }

    fun delete(view: View) {

        marcaStr = marca?.getText().toString()

        val method = "delete"

        val backgroundTask = BackgroundTask(this)
        backgroundTask.execute(method, marcaStr)
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
