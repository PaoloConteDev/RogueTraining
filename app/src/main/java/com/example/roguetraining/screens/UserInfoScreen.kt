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

    // Funzione per validare il form
    fun isFormValid(): Boolean {
        if (sexState == null) {
            errorMessage = "Seleziona il tuo sesso"
            return false
        }
        
        val ageValue = ageState.toIntOrNull()
        val weightValue = weightState.toFloatOrNull()
        val heightValue = heightState.toFloatOrNull()

        if (ageValue == null || weightValue == null || heightValue == null) {
            errorMessage = "Inserisci valori validi in tutti i campi"
            return false
        }

        if (ageValue < 13 || ageValue > 100) {
            errorMessage = "L'età deve essere tra 13 e 100 anni"
            return false
        }

        if (weightValue < 30 || weightValue > 200) {
            errorMessage = "Il peso deve essere tra 30 e 200 kg"
            return false
        }

        if (heightValue < 100 || heightValue > 250) {
            errorMessage = "L'altezza deve essere tra 100 e 250 cm"
            return false
        }

        errorMessage = ""
        return true
    }

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                "Informazioni Utente",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 18.dp)
            )

            Text(
                "Inserisci i tuoi dati per un allenamento personalizzato",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f)
                ),
                modifier = Modifier.padding(bottom = 28.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
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

                // Age Input
                OutlinedTextField(
                    value = ageState,
                    onValueChange = { 
                        ageState = it
                        it.toIntOrNull()?.let { age -> viewModel.setAge(age) }
                    },
                    label = { Text("Età", color = Color.White) },
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

                // Weight Input
                OutlinedTextField(
                    value = weightState,
                    onValueChange = { 
                        weightState = it
                        it.toIntOrNull()?.let { weight -> viewModel.setWeight(weight) }
                    },
                    label = { Text("Peso (kg)", color = Color.White) },
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

                // Height Input
                OutlinedTextField(
                    value = heightState,
                    onValueChange = { 
                        heightState = it
                        it.toIntOrNull()?.let { height -> viewModel.setHeight(height) }
                    },
                    label = { Text("Altezzo (cm)", color = Color.White) },
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

                Button(
                    onClick = {
                        if (isFormValid()) {
                            onNext(sex, weightState.toFloat(), heightState.toFloat(), ageState.toInt())
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    enabled = isFormValid()
                ) {
                    Text(
                        "Avanti",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            color = Color.White
                        )
                    )
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
            text = if (text == "Male") "♂ Uomo" else "♀ Donna",
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