package com.example.yosep.webservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.google.gson.GsonBuilder
import java.net.URI
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList


class MainInfoActivity : AppCompatActivity() {

    internal lateinit var recyclerView: RecyclerView
    internal lateinit var layoutManager: RecyclerView.LayoutManager
    var server_url = "http://iesayala.ddns.net/josep/getJSON.php"
    // private val server_url = "https://gist.githubusercontent.com/Y0s3p/808ce759a37c94b30681def74ab86857/raw/4b4fac13e0b46ea6ce01e7e7784cd3a07f3beb98/test.json"

    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_info)

        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        getInformation()

    }

    private fun getInformation() {

        val stringRequest = StringRequest(
            Request.Method.GET, server_url,
            Response.Listener { response ->
                val builder = GsonBuilder()
                val gson = builder.create()

                val list = Arrays.asList(*gson.fromJson(response, Array<Componentes>::class.java))

                adapter = RecyclerAdapter(list)
                recyclerView.adapter = adapter
            }, Response.ErrorListener { })
        MySingleton.getmInstance(this).addToRequestQue(stringRequest)

    }

}
