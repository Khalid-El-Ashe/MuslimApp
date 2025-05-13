package com.dev.imuslim.ui.screens.stories

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dev.imuslim.R
import com.dev.imuslim.models.Pages
import com.dev.imuslim.models.Story
import com.dev.imuslim.ui.composables.StoryItem
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StoriesType(
    title: String,
    listItems: List<Story>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Scaffold(topBar = {
        TopAppBar(modifier = modifier.padding(), title = title, navigateBack = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    tint = white
                )
            }
        })
    }, content = {
        Column(
            modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listItems.forEach {
                    item {
                        StoryItem(
                            title = it.name,
                            modifier = modifier,
                            onClick = {
                                navController.navigate(
                                    Pages.Details.createRoute(
                                        it.name, it.content, it.youtube_url
                                    )
                                )
                            })
                    }
                }
            }
        }
    })

//    BackHandler {
//        navController.popBackStack()
//    }
}