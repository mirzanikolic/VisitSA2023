package com.example.visitsacompose.common.feature.tours

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.displayHomeItems
import com.example.visitsacompose.common.model.displayTourSections
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.common.model.enum.TourType
import com.example.visitsacompose.ui.component.FilterButton
import com.example.visitsacompose.ui.component.ItemCard
import com.example.visitsacompose.ui.theme.Typography

@Composable
fun Tours(
    openDetails: (Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val tours = remember { displayHomeItems().filter { it.isTour } }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 22.dp)
                .padding(start = 22.dp)
        ) {
            Icon(
                painterResource(R.drawable.ic_location),
                null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                text = "Tours",
                style = Typography.titleMedium
            )
        }
        LazyRow(
            modifier = Modifier.padding(start = 22.dp, top = 20.dp)
        ) {
            itemsIndexed(displayTourSections()) { index, filter ->
                FilterButton(
                    text = filter.title,
                    isSelected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(top = 8.dp),

            // content padding
            contentPadding = PaddingValues(
                start = 22.dp,
                top = 22.dp,
                bottom = 22.dp
            ),
            content = {
                itemsIndexed(if (selectedIndex == 0) tours else tours.filter {
                    it.tourType == filterTours(
                        selectedIndex
                    )
                }) { index, item ->
                    ItemCard(itemModel = item, onClick = { /*TODO*/ }, openDetails = openDetails)
                }
            }
        )
    }
}

fun filterTours(index: Int): TourType {
    return when (index) {
        1 -> TourType.POPULAR
        2 -> TourType.RECOMMENDED
        else -> TourType.ALL
    }
}