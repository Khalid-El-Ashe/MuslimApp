package com.dev.imuslim.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.dev.imuslim.R
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoreScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(modifier = modifier, title = "المزيد", navigateBack = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "", tint = white)
                }
            })
        },
        content = {
            Box(modifier = modifier
                .fillMaxSize()
                .background(color = white)) {
                Text(text = "More Screen", textAlign = TextAlign.Center)
            }
        })
}