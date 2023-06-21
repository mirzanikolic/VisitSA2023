package com.example.visitsacompose.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.ui.theme.Primary
import com.example.visitsacompose.ui.theme.Typography

@Composable
fun PrimaryButton(
    text: String,
    margin: Dp,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(Primary),
        modifier = Modifier.padding(end = margin)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            style = Typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
