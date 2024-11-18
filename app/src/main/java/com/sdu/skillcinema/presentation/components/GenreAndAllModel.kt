package com.sdu.skillcinema.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

@Composable
fun GenreAndAllModel(
    text: String,
    navPath: String,
    navController: NavController
){
    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .padding(end = 24.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                lineHeight = 19.8.sp

            ),
        )
        TextButton(
            onClick = {
                navController.navigate(navPath)
            }
        ) {
            Text(
                text = "Все",
                style = TextStyle(fontSize = 15.sp),
                color = Color(0xFF3D3BFF),
            )
        }
    }
}