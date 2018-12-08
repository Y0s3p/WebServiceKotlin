package com.example.yosep.webservice

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class BackgroundTask(internal var ctx: Context) : AsyncTask<String, Void, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String): String? {

        val insert_url = "http://192.168.0.161/componentes/insert.php"
        val update_url = "http://192.168.0.161/componentes/modify.php"
        val delete_url = "http://192.168.0.161/componentes/delete.php"

        val method = params[0]

        if (method == "register") {

            val marca = params[1]
            val descripcion = params[2]
            val precio = params[3]

            try {

                val url = URL(insert_url)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                val OS = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(OS, "UTF-8"))
                val data = URLEncoder.encode("marca", "UTF-8") + "=" + URLEncoder.encode(marca, "UTF-8") + "&" +
                        URLEncoder.encode("descripcion", "UTF-8") + "=" + URLEncoder.encode(
                    descripcion,
                    "UTF-8"
                ) + "&" +
                        URLEncoder.encode("precio", "UTF-8") + "=" + URLEncoder.encode(precio, "UTF-8")

                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                OS.close()

                val IS = httpURLConnection.inputStream
                IS.close()

                return "Se ha registrado con exito"

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else if (method == "update") {

            val marca = params[1]
            val descripcion = params[2]
            val precio = params[3]
            val oldmarca = params[4]

            try {

                val url = URL(update_url)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                val OS = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(OS, "UTF-8"))
                val data = URLEncoder.encode("marca", "UTF-8") + "=" + URLEncoder.encode(marca, "UTF-8") + "&" +
                        URLEncoder.encode("descripcion", "UTF-8") + "=" + URLEncoder.encode(
                    descripcion,
                    "UTF-8"
                ) + "&" +
                        URLEncoder.encode("precio", "UTF-8") + "=" + URLEncoder.encode(precio, "UTF-8") + "&" +
                        URLEncoder.encode("oldmarca", "UTF-8") + "=" + URLEncoder.encode(oldmarca, "UTF-8")

                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                OS.close()

                val IS = httpURLConnection.inputStream
                IS.close()

                return "Se ha modificado con exito"

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else if (method == "delete") {

            val marca = params[1]

            try {

                val url = URL(delete_url)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                val OS = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(OS, "UTF-8"))
                val data = URLEncoder.encode("marca", "UTF-8") + "=" + URLEncoder.encode(marca, "UTF-8")

                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                OS.close()

                val IS = httpURLConnection.inputStream
                IS.close()

                return "Se ha borrado con exito"

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        return null
    }

    override fun onProgressUpdate(vararg values: Void) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: String) {

        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show()

    }
}