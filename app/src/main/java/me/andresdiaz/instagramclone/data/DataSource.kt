package me.andresdiaz.instagramclone.data

import me.andresdiaz.instagramclone.model.Post
import me.andresdiaz.instagramclone.model.Story

object DataSource {
    fun getPosts(): List<Post> = listOf(
        Post(1, "android_developer", "https://picsum.photos/seed/user1/200/200", "https://picsum.photos/seed/post1/800/800", 1204, "Explorando Jetpack Compose 🚀 #Android #Kotlin"),
        Post(2, "kotlin_ninja", "https://picsum.photos/seed/user2/200/200", "https://picsum.photos/seed/post2/800/800", 847, "Data classes son la mejor feature de Kotlin 💗", isLiked = true),
        Post(3, "compose_ui", "https://picsum.photos/seed/user3/200/200", "https://picsum.photos/seed/post3/800/800", 3456, "Material3 + Compose = perfecta combinación 🎨"),
        Post(4, "google_devs", "https://picsum.photos/seed/user4/200/200", "https://picsum.photos/seed/post4/800/800", 12891, "Android 25 trae increíbles mejoras de performance!"),
        Post(5, "mobile_craft", "https://picsum.photos/seed/user5/200/200", "https://picsum.photos/seed/post5/800/800", 629, "LazyColumn vs RecyclerView: ¿cuál prefieres? 🤔"),
        Post(6, "ui_android", "https://picsum.photos/seed/user6/200/200", "https://picsum.photos/seed/post6/800/800", 2163, "Animaciones suaves con Compose ✨", isLiked = true),
        Post(7, "dev_colombia", "https://picsum.photos/seed/user7/200/200", "https://picsum.photos/seed/post7/800/800", 445, "Coil hace súper fácil cargar imágenes en Compose 🖼️"),
        Post(8, "jetpack_daily", "https://picsum.photos/seed/user8/200/200", "https://picsum.photos/seed/post8/800/800", 512, "Construyendo interfaces modernas con Jetpack Compose."),
        Post(9, "android_lab", "https://picsum.photos/seed/user9/200/200", "https://picsum.photos/seed/post9/800/800", 734, "Probando imágenes remotas con Coil y Picsum."),
        Post(10, "code_with_me", "https://picsum.photos/seed/user10/200/200", "https://picsum.photos/seed/post10/800/800", 981, "Un feed completo usando LazyColumn y LazyRow.")
    )

    fun getStories(): List<Story> = listOf(
        Story(1, "Tu historia", "https://picsum.photos/seed/s1/200/200", false),
        Story(2, "android_dev", "https://picsum.photos/seed/s2/200/200", false),
        Story(3, "kotlin_fan", "https://picsum.photos/seed/s3/200/200", false),
        Story(4, "google", "https://picsum.photos/seed/s4/200/200", true),
        Story(5, "compose", "https://picsum.photos/seed/s5/200/200", false),
        Story(6, "android_lab", "https://picsum.photos/seed/s6/200/200", false),
        Story(7, "dev_colombia", "https://picsum.photos/seed/s7/200/200", true)
    )
}
