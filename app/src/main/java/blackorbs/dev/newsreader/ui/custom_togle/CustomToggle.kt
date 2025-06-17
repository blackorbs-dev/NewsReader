package blackorbs.dev.newsreader.ui.custom_togle

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import blackorbs.dev.newsreader.ui.theme.NewsReaderTheme

@Composable
fun CustomToggle(
    color: Color = Color.Red,
    size: Dp = 28.dp
){
    var isVisible by remember {
        mutableStateOf(false)
    }
    Crossfade(
        isVisible,
        animationSpec = tween(500)
    ) {
        IconButton(
            onClick = {
                isVisible = !isVisible
            },
            modifier = Modifier.size(size)
        ) {
            Icon(
                if(it) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                null,
                tint = color,
                modifier = Modifier.size(size)
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun CustomTogglePreview(){
    NewsReaderTheme {
        Scaffold {
            CustomToggle(color = Color.Blue, size = 48.dp)
        }
    }
}