package com.example.flash.ui

import androidx.compose.foundation.Image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.R


@Composable
fun CartScreen() {
    /* LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    )
    {
        item {
            Image(
                painter = painterResource(
                    R.drawable.cartbanner), contentDescription = "Offer")
        }
        item {
            Text(text = "Review Items",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp)
        }
        item{
            CartCard()
        }

    }
}
@Composable
fun CartCard(){
    Row (
        modifier = Modifier.fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        AsyncImage(
            model = "https://trainings.internshala.com/uploads/android/grocery_delivery_app/apples.png",
            contentDecription = "Item image",
            modifier = Modifier.fillMaxHeight()
                .padding(start = 5.dp)
                .weight(4f)
        )

        Column(
            modifier = Modifier.padding(horizontal = 5.dp)
                .fillMaxHeight()
                .weight(4f),
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            Text(
                text = "Apples",
                fontSize = 20.sp,
                maxLines = 1
            )
            Text(
                text = "1kg",
                fontSize = 14.sp,
                maxLines = 1
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 5.dp)
                .fillMaxHeight()
                .weight(3f),
            verticalArrangement = Arrangement.Spa
        )
        {
            Text(
                text = "Rs .250",
                fontSize = 12.sp,
                maxLines = 1,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                text = "Rs. 187",
                fontSize = 18.sp,
                maxLines = 1,
                color = Color(254, 116, 105, 255)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(3f),
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            Text(
                text = "Quantity:1",
                fontSize = 11.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Card(
            modifier = Modifier
            .clickable { }
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(254, 116, 105, 255)
            )
        ) {
            Text(
                text = "Remove",
                color = Color.White,
                fontSize = 11.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 6.dp)

            )

        }

    }
}*/
}