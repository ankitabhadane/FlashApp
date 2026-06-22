package com.example.flash.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class FlashAppScreen(){
    Start,
    Items,
    Cart
}
@Composable
fun FlashApp(flashViewModel: FlashViewModel = viewModel(),
             navController: NavHostController = rememberNavController()
){
    Scaffold(
        topBar = {
            Text(text = "Welcome everyone")
        },
        bottomBar = {
    FlashAppBar()
        }
    ) {
        NavHost(navController = navController,
            startDestination = FlashAppScreen.Start.name,
            Modifier.padding(it))
        {
            composable(route = FlashAppScreen.Start.name){
                StartScreen(
                    flashViewModel = flashViewModel,
                    onCategoryClicked = {
                        flashViewModel.updateSelectedCategory(it)
                        navController.navigate(FlashAppScreen.Items.name)
                    }
                )
            }
            composable(route = FlashAppScreen.Items.name){
                ItemsScreen(flashViewModel = flashViewModel)
            }
        }
    }


}

    /*flashViewModel: FlashViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val isVisible by flashViewModel.isVisible.collectAsState()
    val currentScreen = FlashScreen.valueOF(
        backStackEntry?.destination? route >: FlashAppScree.Start.name
    )

    canNavigateBack = navController.previousBackStackEntry != null

    if (isVisible) {
        OfferScreen()
    } else {
        Scaffold {
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = currentScreen.Title,
                            fontSize = 26.sp,
                            fontFamilty = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    },
                    navigationIcon = {
                        if(canNavigateBack) {
                            IconButton(onClick = {
                                navController.navigateUp()
                    })
                {
                            Icon(imageVector = Icon.Filled.ArrowBack,contentDescription = "BackButton")
                }
            }
        }
)
},
bottomBar ={ FlashAppBar(NAvController = navController,
    currentScreen = currentScreen

)},
){
    NavHost(
        navController = navController,
        startDestination = FlashAppScreen.Start.name,
        Modifier.pdding(it)
    )
}
composable(route = FlashAppScree.Start.name){
    StartScreen(
        flashViewModel = flashViewModel,
        onCategoryClicked = {
            flashViewModel.updateSelectedCategory(it)
            navController.navigate(FlashAppScreen.Items.name)
        }
    )
}
composable(route = FlashAppScreen.Items.name){
    InternetItemsScreen(
        flashViewModel = flashViewModel,
        itemUIState = flashViewModel.itemUIState
    )
}
composable(route = FlashAppScreen.Cart.name){
    CartScreen()
}
}
}
}
*/
@Composable
fun FlashAppBar(/*navController: NavHostController,
                currentScreen: FlashAppScreen*/
)
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(
                horizontal = 70.dp,
                vertical = 10.dp
            )
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
         /*   modifier = Modifier.clickable {
                navController.navigate(FlashAppScreen.start.name) {
                   popupTo(0)
                }
            }*/
            )
            {
                Icon(imageVector = Icons.Outlined.Home,
                contentDescription ="Home")
                Text( text = "Home", fontSize = 10.sp)
        }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                /*modifier = Modifier.clickable {
                    if(currentScreen != FlashAppScreen.Cart)
                    {
                        navController.navigate(FlashAppScreen.Cart.name) {
                        }
                    }
                }*/

            ){
                    Icon(imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription ="Cart")
                    Text( text = "Cart", fontSize = 10.sp)
                }
            }
        }





