package com.example.visitsacompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.HomeItemModel
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.ui.theme.LightGray
import com.example.visitsacompose.ui.theme.Transparent
import com.example.visitsacompose.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherChoicesItemCard(
    homeItemModel: HomeItemModel,
    onClick: () -> Unit,
    openDetails: (Int) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Transparent
        ),
        onClick = { openDetails(homeItemModel.id) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(86.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painterResource(id = R.drawable.ic_hotel_central),
                    null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .height(86.dp)
                    .padding(vertical = 6.dp)
            ) {
                Text(
                    text = homeItemModel.name,
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = homeItemModel.address,
                    style = Typography.bodySmall,
                    color = LightGray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f)) // Moved weight(1f) to Spacer
                Row(
                    verticalAlignment = CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = LightGray,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        modifier = Modifier.padding(top = 2.dp, start = 4.dp),
                        text = homeItemModel.city,
                        style = Typography.bodySmall,
                        color = LightGray,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            val annotatedPriceString = buildAnnotatedString {
                append(homeItemModel.cost)
                append(" /Person")
                addStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold),
                    start = 0,
                    end = homeItemModel.cost.length
                )
            }
            Text(
                text = annotatedPriceString,
                style = Typography.bodyLarge,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(CenterVertically)
                    .alpha(if (homeItemModel.type == "restaurant" || homeItemModel.type == "club") 0f else 1f),
            )
        }
    }
}
