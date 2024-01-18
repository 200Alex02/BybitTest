package com.example.bybittest.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(
   tag: String
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(0.5.dp, color = Color.DarkGray),
        modifier = Modifier.padding(start = 10.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.Start),
            text = tag,
            style = TextStyle(
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
        )
    }
}