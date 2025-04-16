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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roguetraining.WorkoutViewModel

@Composable
fun UserInfoScreen(
    onNext: (String, Float, Float, Int) -> Unit,
    onBack: () -> Unit,
    viewModel: WorkoutViewModel
) {
    val sex by viewModel.sex.collectAsStateWithLifecycle()
    val weight by viewModel.weight.collectAsStateWithLifecycle()
    val height by viewModel.height.collectAsStateWithLifecycle()
    val age by viewModel.age.collectAsStateWithLifecycle()
    
    var sexState by remember { mutableStateOf(sex) }
    var weightState by remember { mutableStateOf(if (weight > 0) weight.toString() else "") }
    var heightState by remember { mutableStateOf(if (height > 0) height.toString() else "") }
    var ageState by remember { mutableStateOf(if (age > 0) age.toString() else "") }
    var errorMessage by remember { mutableStateOf("") }
    
    val focusManager = LocalFocusManager.current
    val (ageFocus, weightFocus, heightFocus) = remember { FocusRequester.createRefs() }

    // Update local state when ViewModel values change
    LaunchedEffect(sex, weight, height, age) {
        sexState = sex
        weightState = if (weight > 0) weight.toString() else ""
        heightState = if (height > 0) height.toString() else ""
        ageState = if (age > 0) age.toString() else ""
    }

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
                    isSelected = sexState == "Male",
                    onClick = { 
                        sexState = "Male"
                        viewModel.setSex("Male")
                    }
                )
                SexButton(
                    text = "Female",
                    isSelected = sexState == "Female",
                    onClick = { 
                        sexState = "Female"
                        viewModel.setSex("Female")
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Age Input
            OutlinedTextField(
                value = ageState,
                onValueChange = { 
                    ageState = it
                    it.toIntOrNull()?.let { age -> viewModel.setAge(age) }
                },
                label = { Text("Age", color = Color.White) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { weightFocus.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(ageFocus),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Weight Input
            OutlinedTextField(
                value = weightState,
                onValueChange = { 
                    weightState = it
                    it.toIntOrNull()?.let { weight -> viewModel.setWeight(weight) }
                },
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
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Height Input
            OutlinedTextField(
                value = heightState,
                onValueChange = { 
                    heightState = it
                    it.toIntOrNull()?.let { height -> viewModel.setHeight(height) }
                },
                label = { Text("Height (cm)", color = Color.White) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(heightFocus),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )

            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Navigation Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E4976)
                    ),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text("Back")
                }

                Button(
                    onClick = {
                        if (sexState == null) {
                            errorMessage = "Please select your sex"
                            return@Button
                        }
                        val ageValue = ageState.toIntOrNull()
                        val weightValue = weightState.toFloatOrNull()
                        val heightValue = heightState.toFloatOrNull()

                        if (ageValue == null || weightValue == null || heightValue == null) {
                            errorMessage = "Please fill in all fields with valid numbers"
                            return@Button
                        }

                        if (ageValue < 13 || ageValue > 100) {
                            errorMessage = "Age must be between 13 and 100"
                            return@Button
                        }

                        if (weightValue < 30 || weightValue > 200) {
                            errorMessage = "Weight must be between 30 and 200 kg"
                            return@Button
                        }

                        if (heightValue < 100 || heightValue > 250) {
                            errorMessage = "Height must be between 100 and 250 cm"
                            return@Button
                        }

                        errorMessage = ""
                        onNext(sexState!!, weightValue, heightValue, ageValue)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E4976)
                    ),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text("Next")
                }
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
    // Create a mock Application for preview
    val mockApplication = android.app.Application()
    UserInfoScreen(
        onNext = { _, _, _, _ -> },
        onBack = {},
        viewModel = WorkoutViewModel(mockApplication)
    )
}