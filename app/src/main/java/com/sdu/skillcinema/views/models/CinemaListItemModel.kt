package com.sdu.skillcinema.views.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdu.skillcinema.data.models.CinemaListItem

@Composable
fun CinemaListItemModel(
    data: CinemaListItem,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(22.dp)
            ),
    ){
        Column(
            modifier = Modifier
                .padding(end = 9.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .width(111.dp)
                        .height(156.dp),
                    painter = painterResource(id = data.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = data.rating.toString(),
                    fontSize = 6.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color(0xFF3D3BFF), shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    color = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = 2.dp),
                text = data.title,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
            Text(
                text = data.genre,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        }
    }
}