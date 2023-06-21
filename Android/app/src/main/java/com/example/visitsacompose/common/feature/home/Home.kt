package com.example.visitsacompose.common.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.displaySections
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.ui.component.FilterButton
import com.example.visitsacompose.ui.component.ItemCard
import com.example.visitsacompose.ui.component.OtherChoicesItemCard
import com.example.visitsacompose.ui.theme.CustomGray
import com.example.visitsacompose.ui.theme.Secondary
import com.example.visitsacompose.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    openDetails: (Int) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var selectedIndex by remember { mutableStateOf(0) }
    val state by homeViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
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
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Secondary,
                unfocusedContainerColor = Secondary,
                disabledContainerColor = Secondary,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
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
                        modifier = Modifier
                            .size(20.dp)
                            .align(CenterVertically)
                    )
                    Text(
                        text = "Search...",
                        color = CustomGray,
                        style = Typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(CenterVertically)
                    )
                }
            },
        )
        LazyRow(
            modifier = Modifier.padding(start = 22.dp, top = 20.dp)
        ) {
            itemsIndexed(displaySections()) { index, filter ->
                FilterButton(
                    text = filter.title,
                    isSelected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 20.dp, start = 22.dp),
            text = "Recommended",
            style = Typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        LazyRow(
            modifier = Modifier.padding(top = 20.dp),
            contentPadding = PaddingValues(horizontal = 22.dp)

        ) {
            itemsIndexed(state.attractions.filter { it.type == getTypeFromIndex(selectedIndex) && it.isRecommended }) { index, filter ->
                ItemCard(
                    itemModel = filter,
                    openDetails = openDetails,
                    onClick = { selectedIndex = index }
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 2.dp, start = 22.dp),
            text = "Other choices",
            style = Typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        LazyColumn(
            modifier = Modifier.padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 22.dp)
        ) {
            itemsIndexed(state.attractions.filter { it.type == getTypeFromIndex(selectedIndex) && !it.isRecommended }) { index, filter ->
                OtherChoicesItemCard(
                    homeItemModel = filter,
                    openDetails = openDetails,
                    onClick = { selectedIndex = index }
                )
            }
        }
    }
}

fun getTypeFromIndex(index: Int): String {
    return when (index) {
        0 -> "hotel"
        1 -> "restaurant"
        2 -> "club"
        3 -> "tour"
        else -> "hotel"
    }
}

