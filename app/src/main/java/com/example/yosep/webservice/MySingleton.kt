package com.example.yosep.webservice

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class MySingleton(private val mCtx: Context) {
    private var requestQueue: RequestQueue? = null

    init {
        requestQueue = getRequestQueue()
    }

    private fun getRequestQueue(): RequestQueue? {

        if (requestQueue == null) {

            requestQueue = Volley.newRequestQueue(mCtx.applicationContext)
        }


        return requestQueue

    }

    fun <T> addToRequestQue(request: Request<T>) {

        getRequestQueue()!!.add(request)

    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var mInstance: MySingleton? = null

        @Synchronized
        fun getmInstance(context: Context): MySingleton {

            if (mInstance == null) {

                mInstance = MySingleton(context)

            }
            return mInstance as MySingleton
        }
    }

}
