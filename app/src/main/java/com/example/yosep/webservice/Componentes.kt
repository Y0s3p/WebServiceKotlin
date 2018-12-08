package com.example.yosep.webservice

import com.google.gson.annotations.SerializedName

class Componentes {

    private var marca: String? = null
    private var descripcion:String? = null
    private var precio: Int = 0

    fun getMarca(): String? {
        return marca
    }

    fun setMarca(marca: String) {
        this.marca = marca
    }

    fun getDescripcion(): String? {
        return descripcion
    }

    fun setDescripcion(descripcion: String) {
        this.descripcion = descripcion
    }

    fun getPrecio(): Int {
        return precio
    }

    fun setPrecio(precio: Int) {
        this.precio = precio
    }

}