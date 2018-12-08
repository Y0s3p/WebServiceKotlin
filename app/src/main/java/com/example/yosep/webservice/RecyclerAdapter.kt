package com.example.yosep.webservice

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_view.view.*
import java.io.Serializable


class RecyclerAdapter internal constructor(var list: List<Componentes>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_view, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, i: Int) {

        viewHolder.tv_marca.text = list[i].getMarca()
        viewHolder.tv_descripcion.text = list[i].getDescripcion()
        viewHolder.tv_precio.text = Integer.toString(list[i].getPrecio())

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tv_marca: TextView
        internal var tv_descripcion: TextView
        internal var tv_precio: TextView

        init {

            tv_marca = itemView.findViewById(R.id.item_marca) as TextView
            tv_descripcion = itemView.findViewById(R.id.item_descripcion) as TextView
            tv_precio = itemView.findViewById(R.id.item_precio) as TextView

        }

    }

}