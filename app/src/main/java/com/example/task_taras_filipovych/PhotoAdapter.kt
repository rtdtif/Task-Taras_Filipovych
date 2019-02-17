package com.example.task_taras_filipovych

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_row.view.*

class PhotoAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        val photo = photos[position]
        holder.title.text = photo.title
        val litlePicture = holder.itemView.picture
        Picasso.get().load(photo.thumbnailUrl).into(litlePicture)
        holder?.photo = photo
    }

    class ViewHolder(itemView: View, var photo: Photo? = null ) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.picture_title

        companion object {
            val Photo_Url = "Photo_Url"
        }


        init {
            itemView.setOnClickListener{

                val intent = Intent(itemView.context,BigPictureActivity::class.java)

                intent.putExtra(Photo_Url,photo?.url)

                itemView.context.startActivity(intent)
            }
        }
    }
}
