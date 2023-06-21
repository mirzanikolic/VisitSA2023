package com.example.visitsacompose.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.ui.theme.Primary
import com.example.visitsacompose.ui.theme.Secondary
import com.example.visitsacompose.ui.theme.Transparent

@Composable
fun FilterButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Primary else Color.White
    val backgroundShape =
        if (isSelected) BorderStroke(0.dp, Transparent) else BorderStroke(1.dp, Secondary)

    Box(
        modifier = Modifier
            .padding(end = 15.dp)
            .border(backgroundShape)
            .background(backgroundColor, shape = RoundedCornerShape(5.dp))
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}