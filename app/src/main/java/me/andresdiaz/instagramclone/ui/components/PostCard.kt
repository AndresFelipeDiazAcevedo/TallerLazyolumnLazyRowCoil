package me.andresdiaz.instagramclone.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import me.andresdiaz.instagramclone.model.Post

@Composable
fun PostCard(
    post: Post,
    onLikeClick: (Post) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        PostHeader(post = post)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(post.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Post de ${post.username}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        PostActions(
            post = post,
            onLikeClick = { onLikeClick(post) }
        )
        PostFooter(post = post)
        Divider(color = Color.LightGray.copy(alpha = 0.5f))
    }
}

@Composable
private fun PostHeader(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = post.profileImageUrl,
            contentDescription = post.username,
            modifier = Modifier.size(36.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(10.dp))
        Text(post.username, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Default.MoreVert, contentDescription = "Más opciones")
        }
    }
}

@Composable
private fun PostActions(post: Post, onLikeClick: () -> Unit) {
    var liked by remember { mutableStateOf(post.isLiked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            liked = !liked
            onLikeClick()
        }) {
            Icon(
                imageVector = if (liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Like",
                tint = if (liked) Color.Red else Color.Black
            )
        }
        IconButton(onClick = {}) { Icon(Icons.Default.ChatBubbleOutline, contentDescription = "Comentar") }
        IconButton(onClick = {}) { Icon(Icons.Default.Send, contentDescription = "Enviar") }
        Spacer(Modifier.weight(1f))
        IconButton(onClick = {}) { Icon(Icons.Default.BookmarkBorder, contentDescription = "Guardar") }
    }
}

@Composable
private fun PostFooter(post: Post) {
    // El estado local del like se maneja en PostActions.
    Column(Modifier.padding(horizontal = 12.dp).padding(bottom = 10.dp)) {
        Text(
            text = "${post.likes} Me gusta",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(post.username + " ")
                }
                append(post.caption)
            },
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
