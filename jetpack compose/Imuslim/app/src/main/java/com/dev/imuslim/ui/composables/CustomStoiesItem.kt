package com.dev.imuslim.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.imuslim.R
import com.dev.imuslim.ui.theme.black
import com.dev.imuslim.ui.theme.white

@Composable
fun StoryItem(title: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = white)

    ) {
        Row(
            modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow), contentDescription = "arrow",
                modifier = modifier
                    .fillMaxWidth()
                    .background(white)
                    .weight(0.5f)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right
                ),
                modifier = modifier.weight(2f)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun StoryItemPreview() {
    StoryItem("Title")
}