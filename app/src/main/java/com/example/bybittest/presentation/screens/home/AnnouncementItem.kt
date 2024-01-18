package com.example.bybittest.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bybittest.domain.model.Announcement
import com.example.bybittest.presentation.components.TagItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Composable
fun AnnouncementItem(
    announcement: Announcement
) {
    val uriHandler = LocalUriHandler.current
    Card(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Text(
                text = announcement.title,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    Text(
                        text = formatTimestamp(announcement.dateTimestamp),
                        style = TextStyle(
                            color = Color.Gray,
                            textAlign = TextAlign.Start,
                            fontSize = MaterialTheme.typography.titleSmall.fontSize
                        )
                    )
                }
                items(announcement.tags.size) { index ->
                    TagItem(announcement.tags[index])
                }
            }
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "\uD83C\uDF89 ${announcement.description}",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize
                )
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "\uD83D\uDDD3 Период события: ${
                    formatTimestampRange(
                        announcement.startDateTimestamp,
                        announcement.endDateTimestamp
                    )
                }",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize
                )
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Yellow),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .clickable {
                            uriHandler.openUri(announcement.url)
                        },
                    text = "Участвовать",
                    style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    )
                )
            }
        }
    }
}

private fun formatTimestampRange(startTimestamp: Long, endTimestamp: Long): String {
    val dateFormat = SimpleDateFormat("HH:mm 'UTC' dd MMMM yyyy", Locale("en"))
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")

    val startDate = dateFormat.format(Date(startTimestamp))
    val endDate = dateFormat.format(Date(endTimestamp))

    return "$startDate — $endDate"
}

private fun formatTimestamp(dateTimestamp: Long): String {
    val dateFormat = SimpleDateFormat("d MMM. yyyy 'г.'", Locale("en"))
    return dateFormat.format(Date(dateTimestamp))
}

