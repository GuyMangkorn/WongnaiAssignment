package com.example.wongnaiassignment.recyclerCrypto

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.wongnaiassignment.R
import com.example.wongnaiassignment.api.CoinsObject

class CryptoAdapter (private val result:ArrayList<CoinsObject>,private val context: Context) : RecyclerView.Adapter<CryptoAdapter.Holder>(){
    private val requestBuilder:RequestBuilder<PictureDrawable> = Glide.with(context)
        .`as`(PictureDrawable::class.java)
        .placeholder(R.drawable.ic_outline_cancel_24)
        .error(R.drawable.ic_outline_cancel_24)
        .listener(SvgSoftwareLayerSetter())
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val name:TextView = itemView.findViewById(R.id.nameCrypto)
        private val description:TextView = itemView.findViewById(R.id.descriptionCrypto)
        private val imageCrypto:ImageView = itemView.findViewById(R.id.imageCrypto)
        fun set(position: Int){
            name.text = result[position].name
            description.text = result[position].description
            val uri:Uri = Uri.parse(result[position].iconUrl)
            requestBuilder.load(uri).into(imageCrypto)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.set(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }
}