package com.example.visitsacompose.common.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.R
import com.example.visitsacompose.ui.theme.Typography

@Composable
fun Settings() {
    var switchOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(top = 22.dp, start = 22.dp, end = 22.dp)
    ) {
        Text(
            text = "General",
            style = Typography.bodyMedium,
            fontWeight = FontWeight.Normal
        )
        // Language
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_globe),
                null
            )
            Text(
                "Language",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.ic_next),
                null
            )
        }
        // endregion
        Text(
            text = "About",
            style = Typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 32.dp)
        )
        // Legal
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_shield),
                null
            )
            Text(
                "Legal and Policies",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.ic_next),
                null
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_help),
                null
            )
            Text(
                "Help & Support",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.ic_next),
                null
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_dark),
                null
            )
            Text(
                "Dark Mode",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = switchOn,
                onCheckedChange = { switchOn_ ->
                    switchOn = switchOn_
                }
            )
        }
    }
}