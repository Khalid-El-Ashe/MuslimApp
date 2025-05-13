package com.dev.imuslim.models

import android.net.Uri

sealed class Pages(val title: String, val rout: String) {
    object Home : Pages(title = "Home", rout = "home_rout")
    object More : Pages(title = "More", rout = "more_rout")
    object Details : Pages(title = "Details", rout = "details_rout") {
        fun createRoute(name: String, content: String, url: String): String {
            return "details_rout?name=${Uri.encode(name)}&content=${
                Uri.encode(
                    content
                )
            }&youtube_url=${Uri.encode(url)}"
        }
    }

    object Stories : Pages(title = "Stories", rout = "stories_rout")
    object StoriesType : Pages(title = "StoriesType", rout = "stories_type_rout") {
        fun createRoute(title: String, listItems: String): String {
            return "stories_type_rout?title_story=${Uri.encode(title)}&list_items=${Uri.encode(listItems)}"
        }
    }

    object Notes : Pages(title = "Notes", rout = "notes_rout")
}