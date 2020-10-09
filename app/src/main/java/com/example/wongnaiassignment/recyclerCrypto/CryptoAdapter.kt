package com.example.wongnaiassignment.recyclerCrypto


import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.wongnaiassignment.R


class CryptoAdapter(private val result: ArrayList<CoinsObject>, private val context: Context) : RecyclerView.Adapter<CryptoAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val name:TextView = itemView.findViewById(R.id.nameCrypto)
        private val description:TextView = itemView.findViewById(R.id.descriptionCrypto)
        private val imageCrypto:ImageView = itemView.findViewById(R.id.imageCrypto)
        fun set(position: Int) {
            name.text = result[position].name
            val descriptionText:String? = result[position].description
            if(descriptionText != null) {
                description.text = HtmlCompat.fromHtml(descriptionText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }else{
                description.text = context.getString(R.string.no_description)
            }
            val url:String? =  result[position].iconUrl
            url.let {
                Glide.with(context).load(Uri.parse(it))
                    .thumbnail(0.1f)
                    .placeholder(loading())
                    .into(imageCrypto)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.set(position)
    }

    override fun getItemCount(): Int {
        return result.size
    }
    private fun loading():Drawable{
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.setColorSchemeColors(ContextCompat.getColor(context,R.color.colorDescription))
        circularProgressDrawable.start()
        return circularProgressDrawable
    }
}