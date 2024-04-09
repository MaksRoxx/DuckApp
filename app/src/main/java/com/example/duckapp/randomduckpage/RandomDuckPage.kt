package com.example.duckapp.randomduckpage

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.duckapp.ui.theme.Pink40

@Composable
fun DuckScreen(viewModel: RandomDuckPageViewModel) {
    val duck by viewModel.duckLiveData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        duck?.let {
            Text(text = it.message, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Pink40)
            Spacer(modifier = Modifier.height(10.dp))
            DuckImage(duckImage = it.url)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.getQuack()
        }) {
            Text(text = "Get duck")
        }
    }
}

@Composable
fun DuckImage(duckImage: String) {
    val isGif = duckImage.endsWith(".gif", ignoreCase = true)
    if (isGif) {
        val context = LocalContext.current
        val imageLoader = ImageLoader.Builder(context)
            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        Image(
            painter = rememberAsyncImagePainter(
                model = duckImage,
                imageLoader = imageLoader
            ),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(400.dp)
        )
    } else {
        AsyncImage(
            model = duckImage,
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(400.dp)
        )
    }
}