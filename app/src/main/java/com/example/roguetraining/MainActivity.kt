package com.example.roguetraining

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.roguetraining.ui.theme.RogueTrainingTheme
import com.example.roguetraining.screens.*
import com.example.roguetraining.ui.components.AppTopBar
import com.example.roguetraining.ui.theme.setSystemUiStyle
import com.example.roguetraining.database.TrainingEnvironmentDatabase
import com.example.roguetraining.database.ToolDatabase
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roguetraining.models.TrainingIntensity
import com.example.roguetraining.models.TrainingEnvironment
import com.example.roguetraining.screens.SummaryScreen

class MainActivity : ComponentActivity() {
    private val viewModel: WorkoutViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RogueTrainingTheme {
                setSystemUiStyle()

                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route ?: "welcome"
                val environment by viewModel.environment.collectAsStateWithLifecycle()
                val workoutStartTime = remember { mutableStateOf(0L) }

                // Function to set default medium settings
                fun setDefaultSettings() {
                    viewModel.setSex("Male") // Default to male
                    viewModel.setWeight(75) // Default weight
                    viewModel.setHeight(175) // Default height
                    viewModel.setAge(30) // Default age
                    viewModel.setTrainingType("Mixed") // Default training type
                    viewModel.setFrequency(3) // Default frequency
                    viewModel.setDuration(2) // Default to 1 hour (medium)
                    viewModel.setIntensity(TrainingIntensity.MEDIUM) // Default intensity
                    viewModel.setEnvironment(TrainingEnvironmentDatabase.environments[3]) // Default to Medium Gym
                    viewModel.setTools(ToolDatabase.allTools.map { it.name }) // All tools
                    viewModel.setMuscleGroups(listOf("Chest", "Back", "Legs", "Shoulders", "Arms", "Core")) // All muscle groups
                }

                val targetProgress = when (currentRoute) {
                    "welcome" -> 0f
                    "userInfo" -> 0f
                    "trainingType" -> 1f / 7f
                    "frequency" -> 2f / 7f
                    "duration" -> 3f / 7f
                    "intensity" -> 4f / 7f
                    "environment" -> 5f / 7f
                    "tools" -> 6f / 7f
                    "muscleGroups" -> 7f / 7f
                    else -> 0f
                }

                val progress by animateFloatAsState(
                    targetValue = targetProgress,
                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
                    label = "progressAnimation"
                )

                val title = when (currentRoute) {
                    "welcome" -> "Benvenuto"
                    "userInfo" -> "Informazioni Utente"
                    "trainingType" -> "Tipo di Allenamento"
                    "frequency" -> "Frequenza"
                    "duration" -> "Durata"
                    "intensity" -> "Intensità"
                    "environment" -> "Ambiente di Allenamento"
                    "tools" -> "Strumenti"
                    "muscleGroups" -> "Gruppi Muscolari"
                    "recap" -> "Riepilogo Allenamento"
                    "workout" -> "Allenamento"
                    "summary" -> "Riepilogo"
                    else -> ""
                }

                // Gestione della visibilità delle barre di sistema
                LaunchedEffect(currentRoute) {
                    if (currentRoute == "welcome" || currentRoute == "summary") {
                        window.setFlags(
                            WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN
                        )
                    } else {
                        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    }
                }

                Scaffold(
                    topBar = {
                        AppTopBar(
                            navController = navController,
                            progress = progress,
                            onSkip = {
                                setDefaultSettings()
                                viewModel.generateWorkout() // Generate workout with default settings
                                navController.navigate("recap")
                            }
                        )
                    }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "welcome",
                            modifier = Modifier.fillMaxSize()
                        ) {
                            composable(
                                "welcome",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                WelcomeScreen(
                                    onStartWorkout = { navController.navigate("userInfo") },
                                    onBack = { navController.navigateUp() },
                                    viewModel = viewModel
                                )
                            }
                            composable(
                                "userInfo",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                UserInfoScreen(
                                    onNext = { sex, weight, height, age ->
                                        viewModel.setSex(sex)
                                        viewModel.setWeight(weight.toInt())
                                        viewModel.setHeight(height.toInt())
                                        viewModel.setAge(age)
                                        navController.navigate("trainingType")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    },
                                    viewModel = viewModel
                                )
                            }
                            composable(
                                "trainingType",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                TrainingTypeScreen(
                                    onNext = { selectedType ->
                                        viewModel.setTrainingType(selectedType)
                                        navController.navigate("frequency")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "frequency",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                FrequencyScreen(
                                    onNext = { frequency ->
                                        viewModel.setFrequency(frequency)
                                        navController.navigate("duration")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "duration",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                DurationScreen(
                                    onNext = { duration ->
                                        viewModel.setDuration(duration)
                                        navController.navigate("intensity")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "intensity",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                IntensityScreen(
                                    onNext = { intensity ->
                                        viewModel.setIntensity(TrainingIntensity.valueOf(intensity))
                                        navController.navigate("environment")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "environment",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                EnvironmentSelectionScreen(
                                    onNext = { environment ->
                                        viewModel.setEnvironment(environment)
                                        navController.navigate("tools")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "tools",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                ToolSelectionScreen(
                                    environment = environment,
                                    onToolsSelected = { tools ->
                                        viewModel.setTools(tools)
                                    },
                                    onGenerateWorkout = {
                                        viewModel.generateWorkout()
                                        navController.navigate("muscleGroups")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "muscleGroups",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                MuscleGroupsScreen(
                                    onNext = { muscleGroups ->
                                        viewModel.setMuscleGroups(muscleGroups)
                                        navController.navigate("recap")
                                    },
                                    onNavigateReady = { navController.navigate("recap") },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "recap",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                WorkoutRecapScreen(
                                    viewModel = viewModel,
                                    onStartWorkout = {
                                        navController.navigate("workout")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "workout",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                LaunchedEffect(Unit) {
                                    workoutStartTime.value = System.currentTimeMillis()
                                }
                                WorkoutScreen(
                                    viewModel = viewModel,
                                    onWorkoutComplete = {
                                        navController.navigate("summary")
                                    },
                                    onBack = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                            composable(
                                "summary",
                                enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
                            ) {
                                SummaryScreen(
                                    viewModel = viewModel,
                                    workoutDuration = System.currentTimeMillis() - workoutStartTime.value,
                                    onBack = {
                                        navController.navigate("welcome") {
                                            popUpTo("welcome") { inclusive = true }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}