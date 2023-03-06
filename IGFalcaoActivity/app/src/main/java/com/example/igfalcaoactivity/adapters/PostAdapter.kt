package com.example.igfalcaoactivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.igfalcaoactivity.R
import com.example.igfalcaoactivity.events.OnDataChangeListener
import com.example.igfalcaoactivity.model.PostRepository
import com.example.igfalcaoactivity.viewholder.PostViewHolder


class PostAdapter(postRepository : PostRepository) : RecyclerView.Adapter<PostViewHolder>() , OnDataChangeListener {

    private var repository = postRepository

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.post, parent, false)
        val skeleton = PostViewHolder(root)
        return skeleton
    }

    override fun getItemCount(): Int {
        return repository.getAll().size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val model = repository.getAll()[position]
        holder.profileNameTV.text = model.publisherName
        //holder.postImg = model.postImaURL

        val url = model.postImaURL
        Glide.with(holder.postImg).load(url).into(holder.postImg)
    }

    override fun OnDataChangeListener() {
        notifyItemInserted(repository.getAll().lastIndex)
    }

}