package com.example.visitsacompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.HomeItemModel
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.ui.theme.LightGray
import com.example.visitsacompose.ui.theme.Primary
import com.example.visitsacompose.ui.theme.Transparent
import com.example.visitsacompose.ui.theme.TransparentGray
import com.example.visitsacompose.ui.theme.Typography
import com.example.visitsacompose.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(
    itemModel: HomeItemModel,
    onClick: () -> Unit,
    openDetails: (Int) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Transparent
        ),
        onClick = { openDetails(itemModel.id) },
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        Column(modifier = Modifier.width(175.dp)) {
            Box(
                modifier = Modifier
                    .size(width = 175.dp, height = 165.dp)
                    .fillMaxSize()
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painterResource(id = R.drawable.ic_hotel_central),
                    null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    text = itemModel.type.lowercase().capitalize(),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp)
                        .background(TransparentGray, RoundedCornerShape(16.dp))
                        .padding(vertical = 4.dp, horizontal = 10.dp),
                    color = Color.White,
                    letterSpacing = (-0.25).sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 4.dp)
            ) {
                Text(
                    text = itemModel.name,
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = itemModel.address,
                    style = Typography.bodySmall,
                    color = LightGray
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = returnPricing(itemModel.price),
                        style = Typography.bodySmall,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_star),
                            contentDescription = "Rating",
                            tint = Yellow
                        )
                        Text(
                            text = itemModel.averageRating.toString(),
                            style = Typography.bodySmall,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Primary,
                            modifier = Modifier.padding(start = 4.dp, end = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

fun returnPricing(value: Int): String {
    return when (value) {
        1 -> "$"
        2 -> "$$"
        3 -> "$$$"
        4 -> "$$$$"
        5 -> "$$$$$"
        else -> "N/A"
    }
}