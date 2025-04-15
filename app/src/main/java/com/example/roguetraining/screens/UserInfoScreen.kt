package com.example.roguetraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun UserInfoScreen(
    onNext: (String, Float, Float, Int) -> Unit,
    onBack: () -> Unit
) {
    var sex by remember { mutableStateOf<String?>(null) }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    
    val focusManager = LocalFocusManager.current
    val (weightFocus, heightFocus, ageFocus) = remember { FocusRequester.createRefs() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Informazioni Utente",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            // Sex Selection
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SexButton(
                    text = "Male",
                    isSelected = sex == "Male",
                    onClick = { sex = "Male" }
                )
                SexButton(
                    text = "Female",
                    isSelected = sex == "Female",
                    onClick = { sex = "Female" }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Weight Input
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight (kg)", color = Color.White) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { heightFocus.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(weightFocus),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Height Input
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height (cm)", color = Color.White) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { ageFocus.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(heightFocus),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Age Input
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age", color = Color.White) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(ageFocus),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    try {
                        val weightValue = weight.toInt()
                        val heightValue = height.toInt()
                        val ageValue = age.toInt()
                        
                        if (sex == null) {
                            errorMessage = "Please select your sex"
                            return@Button
                        }
                        if (weightValue <= 0) {
                            errorMessage = "Please enter a valid weight"
                            return@Button
                        }
                        if (heightValue <= 0) {
                            errorMessage = "Please enter a valid height"
                            return@Button
                        }
                        if (ageValue <= 0) {
                            errorMessage = "Please enter a valid age"
                            return@Button
                        }
                        
                        errorMessage = ""
                        onNext(sex!!, weightValue.toFloat(), heightValue.toFloat(), ageValue)
                    } catch (e: NumberFormatException) {
                        errorMessage = "Please enter valid numbers"
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    "Next",
                    color = Color(0xFF0A1929),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun SexButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.White else Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color(0xFF0A1929) else Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
fun PreviewUserInfoScreen() {
    UserInfoScreen({ _, _, _, _ -> }, {})
}