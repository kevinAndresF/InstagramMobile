package com.example.igfalcaoactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.igfalcaoactivity.adapters.PostAdapter
import com.example.igfalcaoactivity.databinding.ActivityMainBinding
import com.example.igfalcaoactivity.model.Post
import com.example.igfalcaoactivity.model.PostRepository

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val repository = PostRepository()
    private val adapter = PostAdapter(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        repository.suscribe(adapter)

        binding.postList.layoutManager = LinearLayoutManager(this)
        binding.postList.adapter = adapter
        binding.postList.setHasFixedSize(true)

        binding.addButton.setOnClickListener {
            val post = Post("Falcao", "https://caracoltv.brightspotcdn.com/dims4/default/2c6d28d/2147483647/strip/true/crop/1000x716+0+0/resize/1000x716!/quality/90/?url=https%3A%2F%2Fcaracol-brightspot.s3-us-west-2.amazonaws.com%2Fassets%2Fbluradio%2Ffalcao_atletico_madrid_afp.jpg")
            repository.create(post)
        }
    }
}