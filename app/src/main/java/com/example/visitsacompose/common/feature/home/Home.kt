package com.example.visitsacompose.common.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.R
import com.example.visitsacompose.ui.theme.CustomGray
import com.example.visitsacompose.ui.theme.Secondary
import com.example.visitsacompose.ui.theme.Typography
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Home() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 22.dp)
                .padding(start = 22.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_location),
                null,
                modifier = Modifier.align(CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(CenterVertically),
                text = "Welcome to Sarajevo",
                style = Typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Secondary,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            placeholder = {
                Row {
                    Icon(
                        painterResource(id = R.drawable.ic_search), "",
                        tint = CustomGray,
                        modifier = Modifier.size(20.dp).align(CenterVertically)
                    )
                    Text(
                        text = "Search...",
                        color = CustomGray,
                        style = Typography.bodyMedium,
                        modifier = Modifier.padding(start = 6.dp).align(CenterVertically)
                    )
                }
            },

            )
    }
}