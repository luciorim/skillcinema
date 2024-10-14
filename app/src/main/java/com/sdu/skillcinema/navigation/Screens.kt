package com.sdu.skillcinema.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Search() {
    Text (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Search",
        textAlign = TextAlign.Center
    )
}


@Composable
fun Profile() {
    Text (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Profile",
        textAlign = TextAlign.Center
    )
}