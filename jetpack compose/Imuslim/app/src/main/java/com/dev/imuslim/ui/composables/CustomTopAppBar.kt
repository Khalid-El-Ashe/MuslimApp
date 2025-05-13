package com.dev.imuslim.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.imuslim.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigateBack: @Composable () -> Unit = {},
    icon: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp, bottomStart = 10.dp
            )
        ),
        title = { Text(title, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primaryColor,
            titleContentColor = Color.White,
        ),
        actions = {
            icon()
        },
        navigationIcon = {
            navigateBack()
        },
    )
}