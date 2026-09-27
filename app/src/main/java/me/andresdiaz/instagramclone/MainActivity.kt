package me.andresdiaz.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.andresdiaz.instagramclone.ui.screens.FeedScreen
import me.andresdiaz.instagramclone.ui.theme.TallerLazycolumnLazyrowCoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerLazycolumnLazyrowCoilTheme {
                FeedScreen()
            }
        }
    }
}
