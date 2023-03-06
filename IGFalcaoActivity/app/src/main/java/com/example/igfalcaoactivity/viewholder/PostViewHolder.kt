package com.example.igfalcaoactivity.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.igfalcaoactivity.databinding.PostBinding

class PostViewHolder (root : View) : ViewHolder(root) {

    private val binding: PostBinding = PostBinding.bind(root)
    val profileNameTV:TextView = binding.profileNameTV
    val postImg:ImageView = binding.postImg

}