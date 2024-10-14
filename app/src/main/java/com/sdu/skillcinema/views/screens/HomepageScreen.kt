package com.sdu.skillcinema.views.screens

import android.provider.ContactsContract.Data
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdu.skillcinema.data.DataProvider
import com.sdu.skillcinema.data.models.CinemaListItem
import com.sdu.skillcinema.views.models.CinemaListItemModel
import com.sdu.skillcinema.views.models.GenreAndAllModel

@Composable
fun Homepage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(top = 97.dp, start = 24.dp)
        ) {
            Text(
                text = "Skillcinema",
                style = TextStyle(fontSize = 22.sp)
            )

            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            ) {
                items(DataProvider.Films) { list ->
                    GenreAndAllModel(
                        text = list.title
                    )
                    LazyRow(
                        modifier = Modifier.padding(bottom = 16.dp)
                    ) {
                        items(list.list) { item ->
                            CinemaListItemModel(
                                data = item
                            )
                        }
                    }
                }
            }
        }
    }
}
