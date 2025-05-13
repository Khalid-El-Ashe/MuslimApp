package com.dev.imuslim.ui.screens.note

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.imuslim.R
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(modifier = modifier.padding(), title = "Note", icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = "youtube",
                colorFilter = ColorFilter.tint(white),
                modifier = modifier
                    .width(30.dp)
                    .height(30.dp)
            )
        },navigateBack = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", tint = white)
            }
        })
    }, content = {
        Column(
            modifier
                .fillMaxSize()
                .padding(top = 100.dp, end = 10.dp, bottom = 0.dp, start = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Your content here
        }
    })
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun NoteScreenPreview() {
//    NotesScreen()
//}