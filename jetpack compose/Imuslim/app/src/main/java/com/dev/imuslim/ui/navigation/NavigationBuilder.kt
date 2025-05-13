package com.dev.imuslim.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dev.imuslim.models.Pages
import com.dev.imuslim.models.Story
import com.dev.imuslim.ui.screens.DetailScreen
import com.dev.imuslim.ui.screens.HomeScreen
import com.dev.imuslim.ui.screens.MoreScreen
import com.dev.imuslim.ui.screens.note.NotesScreen
import com.dev.imuslim.ui.screens.stories.StoriesScreen
import com.dev.imuslim.ui.screens.stories.StoriesType
import com.dev.imuslim.viewModel.AthckarViewModel
import com.dev.imuslim.viewModel.StoriesViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun NavigationBuilder(controller: NavHostController) {
    val athckarViewModel: AthckarViewModel = viewModel()
    val storiesViewModel: StoriesViewModel = viewModel()

    NavHost(navController = controller, startDestination = Pages.Home.rout) {
        composable(route = Pages.Home.rout) {
            HomeScreen(navController = controller, viewModel = athckarViewModel)
        }
        composable(route = Pages.More.rout) {
            MoreScreen(navController = controller)
        }
        composable(
            route = "${Pages.Details.rout}?name={name}&content={content}&youtube_url={youtube_url}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType; defaultValue = ""
            },
                navArgument("content") { type = NavType.StringType; defaultValue = "" },
                navArgument("youtube_url") {
                    type = NavType.StringType; defaultValue = ""
                })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val youtubeUrl = backStackEntry.arguments?.getString("youtube_url") ?: ""
            DetailScreen(
                navController = controller, title = name, content = content, youtubeUrl = youtubeUrl
            )
        }
        composable(route = Pages.Stories.rout) {
            StoriesScreen(navController = controller, viewModel = storiesViewModel)
        }
        composable(route = "${Pages.StoriesType.rout}?title_story={title_story}&list_items={list_items}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title_story") ?: ""

            val json = backStackEntry.arguments?.getString("list_items") ?: "[]"
            val listType = object : TypeToken<List<Story>>() {}.type
            val listItems: List<Story> = Gson().fromJson(json, listType)

            StoriesType(title = title, listItems = listItems, navController = controller)
        }
        composable(route = Pages.Notes.rout) {
            NotesScreen(navController = controller)
        }
    }
}