package com.dev.imuslim.ui.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dev.imuslim.R
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.black
import com.dev.imuslim.ui.theme.secondaryColor
import com.dev.imuslim.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title: String,
    content: String,
    youtubeUrl: String
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(topBar = {
        TopAppBar(modifier = modifier, title = title, icon = {
            Image(painter = painterResource(id = R.drawable.ic_headphones),
                contentDescription = "",
                modifier = modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(end = 10.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
                        context.startActivity(intent)
                    })
        },
            navigateBack = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", tint = white)
                }
            }
        )
    }, content = {
        Column(
            modifier
                .fillMaxSize()
                .padding(top = 80.dp, end = 0.dp, bottom = 0.dp, start = 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = content,
                textAlign = TextAlign.Right,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.cairo_medium)),
                color = black,
                modifier = modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .padding(15.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .verticalScroll(scrollState)
            )
        }
    })
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DetailsScreenPreview(modifier: Modifier = Modifier) {
//    val controller = NavHostController(context = LocalContext.current)
//    DetailScreen(navController = controller, title = "more", content = "", youtubeUrl = "")
//}