package main.example.food_delivery
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Hotel(val name: String, val dishes: List<Dish>)

data class Dish(val name: String, val imageResId: Int, val price: Double, var isInCart: Boolean = false)
@Composable
fun Screen3(navController: NavHostController) {
    // Sample data representing multiple hotels and their dishes
    val hotels = listOf(
        Hotel("Fast Food Restro", listOf(
            Dish("Burger", R.drawable.moist_chicken_burgers, 3.99),
            Dish("Pasta", R.drawable.pasta, 2.99),
            Dish("Pizza", R.drawable.pizza, 8.99)
        )),
        Hotel("The Breakfast Nook", listOf(
            Dish("Waffle", R.drawable.waffle, 7.99),
            Dish("Pancake", R.drawable.pancake, 8.99),
            Dish("French Toast", R.drawable.french_toast, 11.99)
        )),
        Hotel("Sip & Taste Temptations", listOf(
            Dish("Lemonade", R.drawable.lemonade, 2.49),
            Dish("Strawberry-Banana Smoothie", R.drawable.strawberry_banana_smoothie, 6.49),
            Dish("Passion Fruit Juice", R.drawable.passionfruit_juice, 3.99)
        ))
    )
    //val checkedItems = remember { mutableStateOf(mutableListOf<Dish>()) }

    var selectedDish by remember { mutableStateOf<Dish?>(null) }
    var cart by remember { mutableStateOf<List<Dish>>(emptyList()) }

    LazyColumn {
        items(hotels) { hotel ->
            // Display the hotel name with spacing
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(
                    text = hotel.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }

            // Display the list of dishes for the hotel
            hotel.dishes.forEach { dish ->
                //val isChecked = checkedItems.value.contains(dish)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = dish.imageResId),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp, 80.dp)
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(
                            text = dish.name,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Price: $${String.format("%.2f", dish.price)}", // Display the price
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Checkbox(
                        checked = dish.isInCart,
                        onCheckedChange = { isChecked ->
                            //selectedDish = dish
                            if (isChecked) {
                                cart = cart + listOf(dish)
                            } else {
                                cart = cart - listOf(dish)
                            }

                        }
                    )

                }
            }

            // Add spacing between hotel sections
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Add additional spacing after the last hotel section
        //Spacer(modifier = Modifier.height(16.dp))
    }

//    // Display the selected dish and cart
//    selectedDish?.let { dish ->
//        Text(
//            text = "Selected Dish: ${dish.name}",
//            modifier = Modifier.padding(16.dp),
//            fontWeight = FontWeight.Bold
//        )
//    }
    //val cartSize = checkedItems.value.size
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.weight(1f)) // Pushes the text to the right
        Text(
            text = "Cart: ${cart.size} items",
            fontWeight = FontWeight.Bold
        )
    }

}

//@Preview
//@Composable
//fun Screen3Preview() {
//    // Call your Screen3 composable here
//    Screen3(navController)
//}