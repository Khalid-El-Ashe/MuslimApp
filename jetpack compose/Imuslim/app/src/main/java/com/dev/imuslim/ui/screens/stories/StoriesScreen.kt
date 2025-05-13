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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.imuslim.R
import com.dev.imuslim.models.Pages
import com.dev.imuslim.models.ResultState
import com.dev.imuslim.models.Stories
import com.dev.imuslim.ui.composables.CircularLoading
import com.dev.imuslim.ui.composables.FailureCompose
import com.dev.imuslim.ui.composables.StoryItem
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.white
import com.dev.imuslim.viewModel.StoriesViewModel
import com.google.gson.Gson

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StoriesScreen(
    modifier: Modifier = Modifier, navController: NavController, viewModel: StoriesViewModel
) {

    val state by viewModel.storiesState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(modifier = modifier.padding(), title = "Stories", navigateBack = {
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
            when (state) {
                is ResultState.Loading -> {
                    CircularLoading()
                }

                is ResultState.Success -> {
                    val stories = (state as ResultState.Success<List<Stories>>).data
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        stories.forEach { storiesData ->
                            val storiesJson = Gson().toJson(storiesData.object_stories)
                            item {
                                StoryItem(
                                    title = storiesData.title_story,
                                    modifier = modifier,
                                    onClick = {
                                        storiesData.object_stories.forEach {
                                            navController.navigate(
                                                Pages.StoriesType.createRoute(
                                                    title = storiesData.title_story,
                                                    listItems = storiesJson
                                                )
                                            )
                                        }
                                    })
                            }
                        }
                    }
                }

                is ResultState.Failure -> {
                    FailureCompose()
                }
            }
        }
    })

}

//@Preview
//@Composable
//private fun StoryPreviewScreen() {
//    StoriesScreen(
//        navController = NavController(context = LocalContext.current),
//        viewModel = StoriesViewModel()
//    )
//}