package com.project2.myphotoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.project2.myphotoapp.models.Photo
import com.project2.myphotoapp.models.PhotoList

// Extends the RecyclerView Adapter
class MainAdapter(var photos: List<Photo>,
                  var clickListener: View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return photos.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return PhotoViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.photo_item, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var photo = photos[position]
        holder?.tags?.text = photo.tags

        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo.previewlURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                    .load(photo.previewlURL)
                    .into(holder?.photo_item)
        }

    }

    // will be used by Activity class
    fun getPhoto(adapterPosition: Int): Photo {
        return photos[adapterPosition]
    }


    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // will get red if not initialize the variable.
        var tags: TextView
        var likes: TextView
        var favorites: TextView
        var photo_item: ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById<TextView>(R.id.tags) as TextView
            likes = itemView.findViewById<TextView>(R.id.likes) as TextView
            favorites = itemView.findViewById<TextView>(R.id.favorites) as TextView
            photo_item = itemView.findViewById<ImageView>(R.id.photo_item) as ImageView

        }

    }


}