package com.example.visitsacompose.common.feature.review

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.visitsacompose.ui.theme.Primary
import com.example.visitsacompose.ui.theme.Typography
import com.example.visitsacompose.ui.theme.Yellow

@Composable
fun Review(onRatingSelected: (Int) -> Unit) {

    var selectedRating by remember { mutableStateOf(0) }

    Dialog(
        onDismissRequest = { /* Handle dialog dismiss if needed */ }
    ) {
        Surface(
            modifier = Modifier.width(280.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = 24.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rate this",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (i in 1..5) {
                        IconButton(
                            onClick = { selectedRating = i },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Rating Star",
                                tint = if (i <= selectedRating) Yellow else MaterialTheme.colors.onBackground
                            )
                        }
                    }
                }
                Button(
                    onClick = { onRatingSelected(selectedRating) },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(Primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Submit",
                        modifier = Modifier
                            .padding()
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
