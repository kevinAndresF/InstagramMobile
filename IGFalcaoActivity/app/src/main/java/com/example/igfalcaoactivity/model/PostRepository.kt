package com.example.igfalcaoactivity.model

import com.example.igfalcaoactivity.events.OnDataChangeListener


//Fuente de informacion
class PostRepository {

    private val posts = arrayListOf<Post>()

    private var listener:OnDataChangeListener ?= null

    fun suscribe(listener: OnDataChangeListener){
        this.listener=listener
    }

    init {
        posts.add(Post("James", "https://www.elpais.com.co/files/article_main/uploads/2019/03/17/5c8e9478afb08.jpeg"))
        posts.add(Post("Cuadradinho", "https://e00-co-marca.uecdn.es/claro/assets/multimedia/imagenes/2021/01/07/16100497169823.jpg"))
    }

    fun getAll() : ArrayList<Post>{
        return posts
    }
    fun create(post:Post){
        posts.add(post)
        listener?.let {it.OnDataChangeListener()}

    }

}