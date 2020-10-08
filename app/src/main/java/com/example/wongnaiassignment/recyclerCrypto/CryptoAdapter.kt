package com.example.wongnaiassignment.recyclerCrypto


import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.wongnaiassignment.R
import com.example.wongnaiassignment.api.CoinsObject


class CryptoAdapter(private val result: ArrayList<CoinsObject>, private val context: Context) : RecyclerView.Adapter<CryptoAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val name:TextView = itemView.findViewById(R.id.nameCrypto)
        private val description:TextView = itemView.findViewById(R.id.descriptionCrypto)
        private val imageCrypto:ImageView = itemView.findViewById(R.id.imageCrypto)
        fun set(position: Int) {
            name.text = result[position].name
            description.text = result[position].description
            val url:String = result[position].iconUrl
            Glide.with(context).load(url).listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    return false }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false }
            }).into(imageCrypto)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_crypto,
            parent,
            false
        )
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.set(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }
    fun pngLoad(imageCrypto: ImageView, url: String){
            Glide.with(context).load(url).into(imageCrypto)
    }
}