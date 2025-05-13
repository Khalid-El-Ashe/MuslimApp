package com.dev.imuslim.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.imuslim.viewModel.AthckarViewModel
import com.dev.imuslim.R
import com.dev.imuslim.models.Pages
import com.dev.imuslim.models.ResultState
import com.dev.imuslim.ui.composables.CategoryCard
import com.dev.imuslim.ui.composables.TopAppBar
import com.dev.imuslim.ui.theme.primaryColor
import com.dev.imuslim.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, navController: NavController, viewModel: AthckarViewModel
) {
    val context = LocalContext.current
    val state by viewModel.athkarState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(modifier = modifier.padding(), title = "الرئيسية", icon = {
            Image(
                painter = painterResource(id = R.drawable.ic_note),
                contentDescription = "youtube",
                colorFilter = ColorFilter.tint(white),
                modifier = modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(end = 10.dp)
                    .clickable {
                        navController.navigate("notes_rout")
                    }
            )
        })
    }, content = {

        Box(modifier = modifier.padding(10.dp)) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
                    CategoryCard(
                        title = "أذكار الصباح",
                        imageRes = R.drawable.ic_morning,
                        modifier = modifier
                    ) {
                        when (state) {
                            is ResultState.Loading -> {
                                println("HomeScreen: Loading....")
                            }

                            is ResultState.Success -> {
                                val athkar = (state as ResultState.Success).data
                                athkar.forEach {
                                    athkar.filter { it.id == 0 }.distinctBy {
                                        val name = it.athckar_name
                                        val content = it.athckar_content
                                        val youtubeUrl = it.youtube_url
                                        navController.navigate(
                                            Pages.Details.createRoute(
                                                name, content, youtubeUrl
                                            )
                                        )
                                    }
                                }
                            }

                            is ResultState.Failure -> {
                                val error = (state as ResultState.Failure).msg
                                println("HomeScreen: error = $error")
                            }
                        }
                    }
                    Spacer(modifier = modifier.width(40.dp))
                    CategoryCard(
                        title = "أذكار المساء",
                        imageRes = R.drawable.ic_eveining,
                        modifier = modifier
                    ) {
                        when (state) {
                            is ResultState.Loading -> {
                                println("HomeScreen: Loading....")
                            }

                            is ResultState.Success -> {
                                val athkar = (state as ResultState.Success).data
                                athkar.forEach {
                                    athkar.filter { it.id == 1 }.distinctBy {
                                        val name = it.athckar_name
                                        val content = it.athckar_content
                                        val youtubeUrl = it.youtube_url
                                        navController.navigate(
                                            Pages.Details.createRoute(
                                                name, content, youtubeUrl
                                            )
                                        )
//                                                    navController.navigate("details_rout")
                                    }
                                }
                            }

                            is ResultState.Failure -> {
                                val error = (state as ResultState.Failure).msg
                                println("HomeScreen: error = $error")
                            }
                        }
                    }
                }
                Spacer(modifier = modifier.height(20.dp))

                Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
                    CategoryCard(
                        title = "قصص", imageRes = R.drawable.ic_stories, modifier = modifier
                    ) {
                        navController.navigate("stories_rout")
                    }
                    Spacer(modifier = modifier.width(40.dp))
                    CategoryCard(
                        title = "عن الاسلام", imageRes = R.drawable.ic_about, modifier = modifier
                    ) {
                        Toast.makeText(context, "clicked me", Toast.LENGTH_SHORT).show()
                    }
                }
                Spacer(modifier = modifier.height(20.dp))

                Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
                    CategoryCard(
                        title = "الله", imageRes = R.drawable.ic_allah, modifier = modifier
                    ) {
                        Toast.makeText(context, "clicked me", Toast.LENGTH_SHORT).show()
                    }
                    Spacer(modifier = modifier.width(40.dp))
                    CategoryCard(
                        title = "تسبيح", imageRes = R.drawable.ic_prayer, modifier = modifier
                    ) {
                        Toast.makeText(context, "clicked me", Toast.LENGTH_SHORT).show()
                    }
                }

                Spacer(modifier = modifier.height(50.dp))
                Button(
                    onClick = {
                        navController.navigate("more_rout")
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor, contentColor = white
                    ), modifier = modifier.fillMaxWidth()
                ) {
                    Text(text = "المزيد", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    val viewModel: AthckarViewModel = viewModel()
    HomeScreen(navController = rememberNavController(), viewModel = viewModel)
}