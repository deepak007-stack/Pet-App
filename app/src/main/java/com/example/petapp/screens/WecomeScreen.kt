package com.example.petapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petapp.FunFactComposable
import com.example.petapp.R
import com.example.petapp.TextComponent
import com.example.petapp.TextWithShadow
import com.example.petapp.TopBar
import com.example.petapp.viewmodel.FunFactViewModel

@Composable
fun WelcomeScreen(userName: String?, animalSelected: String?) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            TopBar(value = "welcome $userName \uD83D\uDE0D")
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent("Thank you! for sharing data", size = 22.sp, FontWeight.Normal)
            Spacer(modifier = Modifier.size(50.dp))

//            val finalText = if (animalSelected == "Cat") "You are cat lover" else "You are dog lover"

            if (animalSelected == "Cat") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextWithShadow(name = "You are cat lover")
                    Image(
                        modifier = Modifier
                            .size(45.dp)
                            .padding(start = 10.dp),
                        painter = painterResource(id = R.drawable.cat1),
                        contentDescription = "animal"
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextWithShadow(name = "You are dog lover")
                    Image(
                        modifier = Modifier
                            .size(45.dp)
                            .padding(start = 10.dp),
                        painter = painterResource(id = R.drawable.dog_icon),
                        contentDescription = "animal"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            val funFactViewModel: FunFactViewModel = viewModel()
            FunFactComposable(value = funFactViewModel.generateFact(animalSelected!!))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("Hello", "world")
}