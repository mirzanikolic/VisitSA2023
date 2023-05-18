package com.example.visitsacompose.common.feature.onboarding

import android.content.res.Resources.Theme
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitsacompose.common.model.displayOnboardingList
import com.example.visitsacompose.ui.theme.Detail
import com.example.visitsacompose.ui.theme.Typography
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Onboarding(
    modifier: Modifier,
    openHome: (Unit) -> Unit
) {
    val pagerState = rememberPagerState()
    val onboardingItemList = displayOnboardingList()

    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        HorizontalPager(
            pageCount = onboardingItemList.size,
            state = pagerState
        ) { page ->
            val newObject = onboardingItemList[page]

            Image(
                painterResource(id = newObject.image),
                contentDescription = null,
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier.fillMaxHeight()
            ) {
                Text(
                    text = newObject.title,
                    style = Typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = newObject.body,
                    style = Typography.headlineSmall,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 88.dp),
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = {
                        val nextPage = pagerState.currentPage + 1
                        if (nextPage < onboardingItemList.size) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(nextPage)
                            }
                        } else {
                            openHome(Unit)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
                        .height(60.dp)
                ) {
                    Text(text = "Next", fontSize = 16.sp)
                }
            }
        }

        // Pager indicator positioned above the button
        PagerIndicator(
            pageCount = onboardingItemList.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(136.dp)
        )
    }
}


@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        for (i in 0 until pageCount) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .padding(horizontal = 1.dp)
                    .background(if (i == currentPage) Detail else Color.White)
            )
        }
    }
}