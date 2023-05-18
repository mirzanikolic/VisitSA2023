package com.example.visitsacompose.common.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.R
import com.example.visitsacompose.ui.theme.Typography

@Preview
@Composable
fun Home() {
    Column(
        modifier = Modifier.fillMaxSize().fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(top = 22.dp).padding(start = 22.dp)
        ) {
            Icon(painterResource(R.drawable.ic_location), null, modifier = Modifier.align(CenterVertically))
            Text(
                modifier = Modifier.padding(start = 8.dp).align(CenterVertically),
                text = "Welcome to Sarajevo",
                style = Typography.titleMedium
            )
        }
    }
}