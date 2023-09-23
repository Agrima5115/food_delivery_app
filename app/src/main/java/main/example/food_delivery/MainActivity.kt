package main.example.food_delivery

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//import main.example.food_delivery_app.Screen3

object MainDestinations {
    const val SCREEN1_ROUTE = "screen1"
    const val SCREEN2_ROUTE = "screen2"
    const val SCREEN3_ROUTE = "screen3"
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryApp()
        }
    }
}

@Composable
fun FoodDeliveryAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodDeliveryApp() {
    val navController = rememberNavController()

    FoodDeliveryAppTheme {
        Scaffold(
//            topBar = {
//                TopAppBar(title = { Text(text = "Food Delivery App") })
//            }
        )
            {
            NavHost(navController, startDestination = MainDestinations.SCREEN1_ROUTE) {
                composable(MainDestinations.SCREEN1_ROUTE) {
                    Screen1(navController)
                }
                composable(MainDestinations.SCREEN2_ROUTE) {
                    Screen2(navController)
                }
                composable(MainDestinations.SCREEN3_ROUTE) {
                    Screen3(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun FoodDeliveryAppPreview() {
    FoodDeliveryAppTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = MainDestinations.SCREEN1_ROUTE) {
            composable(MainDestinations.SCREEN1_ROUTE) {
                Screen1(navController)
            }
        }
    }
}
