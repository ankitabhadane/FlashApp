package com.example.flash.ui
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.R
import com.example.flash.data.InternetItem


@Composable
fun ItemsScreen(flashViewModel: FlashViewModel,
                items: List<InternetItem>) {
    val flashUiState by flashViewModel.uiState.collectAsState()
  val selectedCategory = stringResource(id = flashUiState.selectedCategory)
    val database = items.filter {
        it.itemCategory.lowercase() == selectedCategory.lowercase()
    }
    val context = LocalContext.current
    val categoryString = stringResource(id = flashUiState.selectedCategory)

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(database) {
            ItemCard(
                stringResourceId = it.itemName,
                imageResourceId = it.itemUrl,
                itemQuantity = it.itemQuality,
                itemPrice = it.itemPrice
            )

        }
    }
}
@Composable
fun InternetItemScreen(
    flashViewModel: FlashViewModel,
    itemUiState: FlashViewModel.ItemUiState) {
    when (itemUiState) {
        is FlashViewModel.ItemUiState.Loading -> {

            LoadingScreen()
        }

        is FlashViewModel.ItemUiState.Success -> {
            //Text(text = itemUiState.items.toString())
            ItemsScreen(flashViewModel = flashViewModel, items = itemUiState.items)
        }

        else -> {
            ErrorScreen()
        }
    }

}


@Composable
fun ItemCard(
    stringResourceId: String,
    imageResourceId: String,
    itemQuantity: String,
    itemPrice: Int

) {
    val context = LocalContext.current
    Column(modifier = Modifier.width(150.dp)) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(248,221,248,255)
            )
        ) {
            Box()
            {
                AsyncImage(
                    model = imageResourceId,
                    contentDescription = stringResourceId,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(244, 67, 54, 255)
                        )
                    ) {
                        Text(
                            text = "25% Off",
                            color = Color.White,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(
                                horizontal = 5.dp,
                                vertical = 2.dp
                            )
                        )
                    }
                }
            }
        }
        Text(
            text = stringResourceId,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            maxLines = 1,
            textAlign = TextAlign.Left
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Rs.$itemPrice",
                    fontSize = 6.sp,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color(109, 109, 109, 255),
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Text(
                text = "Rs. ${itemPrice * 75 / 100}",
                fontSize = 10.sp,
                maxLines = 1,
                textAlign = TextAlign.Center,
                color = Color(255, 116, 105, 255)
            )
        }
        Text(
            text = itemQuantity,
            fontSize = 14.sp,
            maxLines = 1,
            color = Color(114, 114, 114, 255)

        )


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .clickable {
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT)
                        .show()
                },
            colors = CardDefaults.cardColors(
                containerColor = Color(108, 194, 111, 255)
            )
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Add to Cart",
                    fontSize = 11.sp,
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun AsyncImage(model: String, contentDescription: String, modifier: Modifier) {
    TODO("Not yet implemented")
}

@Composable
    fun LoadingScreen()
    {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            Image(
                painterResource(id = R.drawable.loading),
                contentDescription = "Loading "
            )
        }
    }

    @Composable
    fun ErrorScreen() {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            Image(
                painterResource(id = R.drawable.error),
                contentDescription = "Error "
            )
        }
    }





