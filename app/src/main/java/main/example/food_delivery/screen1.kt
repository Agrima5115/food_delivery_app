package main.example.food_delivery
//import MainDestinations
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen1(navController: NavController?) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Background image
    val background: Painter = painterResource(id = R.drawable.background)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = background,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                modifier = Modifier
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Handle login/signup logic here
                    // Navigate to Screen2 after successful login/signup
                    navController?.navigate(MainDestinations.SCREEN2_ROUTE)
                }
            ) {
                Text(text = "Login/Sign Up")
            }
        }
    }
}


@Preview
@Composable
fun Screen1Preview() {
    // You can call your Screen1 composable here with null NavController
    Screen1(navController = null)
}
