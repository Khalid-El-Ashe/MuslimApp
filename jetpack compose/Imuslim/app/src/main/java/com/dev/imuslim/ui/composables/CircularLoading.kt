package com.dev.imuslim.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.imuslim.ui.theme.secondaryColor
import com.dev.imuslim.ui.theme.primaryColor

@Composable
fun CircularLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp).align(Alignment.Center),
            color = primaryColor,
            trackColor = secondaryColor,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun CircularPreview() {
    CircularLoading(modifier = Modifier.fillMaxSize())
}