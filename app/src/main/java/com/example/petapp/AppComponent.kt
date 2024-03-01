package com.example.petapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(75.dp),
            painter = painterResource(id = R.drawable.travel),
            contentDescription = ""
        )
    }
}


@Composable
fun TextComponent(value: String, size: TextUnit, weight: FontWeight) {
    Text(
        text = value,
        fontSize = size,
        fontWeight = weight,
        color = MaterialTheme.colorScheme.onSurface
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(onTextChange: (name: String) -> Unit) {

    var currentValue by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange(it)
        },
        label = { Text(text = "Name") },
        placeholder = { Text(text = "Enter your name") },
        keyboardActions = KeyboardActions { localFocusManager.clearFocus() },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )
}


@Composable
fun AnimalComponent(id: Int, selected: Boolean, onAnimalSelected: (name: String) -> Unit) {

    Card(
        modifier = Modifier
            .size(160.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//        colors =
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 2.dp,
                    color = if (selected) Color.Blue else Color.Transparent
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = "Animal Image",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        val animalName = if (id == R.drawable.cat1) "Cat" else "Dog"
                        onAnimalSelected(animalName)
                    }
            )
        }
    }
}


@Composable
fun ButtonComponent(goToWelcomeScreen: () -> Unit) {

    Button(modifier = Modifier
        .padding(bottom = 18.dp)
        .fillMaxWidth(),
        onClick = {
            goToWelcomeScreen()
        }) {
        Text(
            text = "Go to welcome screen",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}


@Composable
fun TextWithShadow(name: String) {

    val offset = Offset(1f, 2f)
    Text(
        text = name,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(), offset, 2f)
        )
    )
}

@Composable
fun FunFactComposable(value: String) {

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.quote_icon),
                contentDescription = "quote",
                modifier = Modifier
                    .size(24.dp)
                    .wrapContentSize()
            )
            Spacer(modifier = Modifier.size(24.dp))

            TextWithShadow(name = value)

            Spacer(modifier = Modifier.size(24.dp))

            Image(
                painter = painterResource(id = R.drawable.quote_icon),
                contentDescription = "quote",
                modifier = Modifier
                    .size(24.dp)
                    .wrapContentSize()
                    .rotate(180f)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun FunFactComposablePreview() {
    FunFactComposable("ABCDEF")
}