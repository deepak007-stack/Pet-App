package com.example.petapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petapp.AnimalComponent
import com.example.petapp.AppTextField
import com.example.petapp.ButtonComponent
import com.example.petapp.R
import com.example.petapp.TextComponent
import com.example.petapp.TopBar
import com.example.petapp.viewmodel.UserDataUiEvents
import com.example.petapp.viewmodel.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (value: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")
            Spacer(modifier = Modifier.size(10.dp))

            TextComponent("Let's learn about jetpack!", size = 22.sp, FontWeight.Normal)
            Spacer(modifier = Modifier.size(16.dp))

            TextComponent(stringResource(id = R.string.heading3), size = 18.sp, FontWeight.Normal)
            Spacer(modifier = Modifier.size(55.dp))

            TextComponent(value = "Name", size = 15.sp, FontWeight.Normal)
            Spacer(modifier = Modifier.size(5.dp))

            AppTextField() {
                userInputViewModel.onEventChange(
                    UserDataUiEvents.UserNameEntered(it)
                )
            }
            Spacer(modifier = Modifier.size(25.dp))

            TextComponent(value = "What do you like", size = 18.sp, FontWeight.Normal)

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                Modifier.padding(10.dp)
            ) {
                AnimalComponent(
                    id = R.drawable.cat1,
                    onAnimalSelected = {
                        userInputViewModel.onEventChange(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Cat"
                )
                Spacer(modifier = Modifier.weight(1f))
                AnimalComponent(
                    id = R.drawable.dog_icon,
                    onAnimalSelected = {
                        userInputViewModel.onEventChange(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Dog"
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent {
                    showWelcomeScreen(
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalSelected
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserInputScreenPreview() {
//    UserInputScreen()
}