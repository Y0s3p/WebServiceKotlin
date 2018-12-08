package com.example.yosep.webservice

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.content.Intent
import com.google.gson.GsonBuilder
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //internal var jsonString = "https://gist.githubusercontent.com/Y0s3p/808ce759a37c94b30681def74ab86857/raw/4b4fac13e0b46ea6ce01e7e7784cd3a07f3beb98/test.json"

    var jsonString = "http://iesayala.ddns.net/json/jsonguitarras.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_conect -> {

                conect()

            }
            R.id.nav_showData -> {

                val intent = Intent(this, MainInfoActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_insert -> {

                val intent = Intent(this, MainInsertActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_update -> {

                val intent = Intent(this, MainUpdateActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_delete -> {

                val intent = Intent(this, MainDeleteActivity::class.java)
                startActivity(intent)

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



    fun conect(){

        val stringRequest = StringRequest(
            Request.Method.GET, jsonString,
            Response.Listener { response ->

                Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_LONG).show()

            }, Response.ErrorListener {

                Toast.makeText(applicationContext, "No ha funcionado", Toast.LENGTH_LONG).show()

            })
        MySingleton.getmInstance(this).addToRequestQue(stringRequest)

    }
}
