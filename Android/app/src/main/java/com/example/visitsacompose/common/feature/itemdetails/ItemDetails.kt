package com.example.visitsacompose.common.feature.itemdetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.visitsacompose.R
import com.example.visitsacompose.common.util.Constants
import com.example.visitsacompose.ui.component.PrimaryButton
import com.example.visitsacompose.ui.component.returnImageDrawable
import com.example.visitsacompose.ui.theme.LightGray
import com.example.visitsacompose.ui.theme.Typography
import com.example.visitsacompose.ui.theme.Yellow

@Composable
fun ItemDetails(
    viewModel: ItemDetailsViewModel = hiltViewModel(),
    onClick: () -> Unit,
    onReview: (itemId: Int) -> Unit
) {

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    val optionsScrollState = rememberScrollState()
    val itemId = state.attraction.id

    if (!state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(optionsScrollState)
        ) {
            Column(
                Modifier
                    .padding(top = 22.dp)
            ) {
                Icon(
                    painterResource(R.drawable.ic_back),
                    null,
                    modifier = Modifier
                        .padding(start = 22.dp)
                        .clickable { onClick() }
                )
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = state.attraction.name,
                        style = Typography.titleMedium,
                        modifier = Modifier.align(CenterVertically),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
                Image(
                    painterResource(id = returnImageDrawable(state.attraction.image)),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(vertical = 22.dp, horizontal = 22.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier.padding(vertical = 22.dp, horizontal = 22.dp),
                    verticalAlignment = CenterVertically
                ) {
                    Column() {
                        Text(
                            text = state.attraction.name,
                            fontSize = 24.sp,
                            style = Typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(
                            verticalAlignment = CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_location),
                                contentDescription = null,
                                tint = LightGray,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                modifier = Modifier.padding(top = 2.dp, start = 4.dp),
                                text = state.attraction.address,
                                style = Typography.bodySmall,
                                color = LightGray,
                                fontSize = 12.sp
                            )
                            Icon(
                                painterResource(id = R.drawable.ic_star),
                                contentDescription = "Rating",
                                tint = Yellow,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            Text(
                                text = if (state.attraction.averageRating != null) state.attraction.averageRating.toString() else "",
                                style = Typography.bodySmall,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Yellow,
                                modifier = Modifier.padding(start = 4.dp, end = 10.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painterResource(id = R.drawable.ic_love),
                        contentDescription = "Love",
                        modifier = Modifier.clickable {
                            onReview(state.attraction.id)
                        }
                    )
                }
                Text(
                    text = "Details",
                    style = Typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 22.dp)
                )
                Text(
                    text = state.attraction.details ?: "",
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 22.dp, top = 22.dp, end = 22.dp),
                    lineHeight = 28.sp,
                    letterSpacing = 0.5.sp
                )
                Row(
                    modifier = Modifier.padding(top = 22.dp, start = 22.dp, bottom = 22.dp)
                ) {
                    val annotatedPriceString = buildAnnotatedString {
                        append(state.attraction.cost)
                        append(" / Person")
                        addStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = state.attraction.cost.length
                        )
                    }
                    Text(
                        text = annotatedPriceString,
                        style = Typography.bodyLarge,
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(CenterVertically)
                            .alpha(if (state.attraction.type == "restaurant") 0f else 1f),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    PrimaryButton(
                        onClick = {
                            openLink(
                                if (state.attraction.isTour) Constants.TOUR_OFFICE else state.attraction.url,
                                context
                            )
                        },
                        text =
                        if (state.attraction.type == "tour") "Book Now" else "Contact property",
                        margin = 22.dp
                    )
                }
            }
        }
    }
}

fun openLink(url: String?, context: Context) {
    if (url == null) return
    val uri = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}