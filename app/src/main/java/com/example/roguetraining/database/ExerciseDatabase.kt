package com.example.roguetraining.database

import com.example.roguetraining.models.Exercise
import com.example.roguetraining.models.Difficulty

object ExerciseDatabase {
    val allExercises = listOf(
        // REGIONE: PETTO
        // Esercizi a corpo libero per il petto
        Exercise(
            name = "Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posizionati in plank con le mani alla larghezza delle spalle. Abbassa il corpo mantenendo i gomiti vicini al corpo, poi spingi verso l'alto.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "pushup"
        ),
        Exercise(
            name = "Diamond Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani a forma di diamante sotto il petto. Esegui i push-up mantenendo i gomiti vicini al corpo.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "diamond_pushup"
        ),
        Exercise(
            name = "Wide Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani più larghe delle spalle. Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "wide_pushup"
        ),
        Exercise(
            name = "Incline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani su una superficie rialzata (panca o gradino). Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "incline_pushup"
        ),
        Exercise(
            name = "Decline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona i piedi su una superficie rialzata. Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "decline_pushup"
        ),
        Exercise(
            name = "Pike Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In posizione di plank, solleva i glutei formando una V rovesciata. Piega i gomiti abbassando la testa verso il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "pike_pushup"
        ),
        Exercise(
            name = "Handstand Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In verticale contro il muro, abbassa il corpo piegando i gomiti e poi spingi verso l'alto.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "handstand_pushup"
        ),
        
        // Esercizi con manubri per il petto
        Exercise(
            name = "Dumbbell Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca con un manubrio in ogni mano. Spingi i manubri verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_bench_press"
        ),
        Exercise(
            name = "Incline Dumbbell Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca inclinata con un manubrio in ogni mano. Spingi i manubri verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "incline_dumbbell_press"
        ),
        Exercise(
            name = "Dumbbell Flyes",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca con un manubrio in ogni mano. Con le braccia leggermente piegate, abbassa i manubri ai lati e poi sollevali verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_flyes"
        ),
        
        // Esercizi con bilanciere per il petto
        Exercise(
            name = "Barbell Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca con il bilanciere sopra il petto. Abbassa il bilanciere al petto e poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "barbell_bench_press"
        ),
        Exercise(
            name = "Decline Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca declinata con il bilanciere sopra il petto. Abbassa il bilanciere al petto e poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "decline_bench_press"
        ),
        
        // Esercizi con macchine per il petto
        Exercise(
            name = "Cable Flyes",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi tra due cavi, afferra le maniglie con le braccia leggermente piegate. Porta le braccia in avanti e insieme come per abbracciare un albero.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "cable_flyes"
        ),
        Exercise(
            name = "Machine Chest Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Chest Press Machine"),
            description = "Seduto alla macchina, afferra le maniglie. Spingi le maniglie in avanti estendendo le braccia, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "machine_chest_press"
        ),
        Exercise(
            name = "Smith Machine Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Smith Machine"),
            description = "Sdraiati su una panca sotto la Smith Machine. Afferra il bilanciere e abbassalo al petto, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "smith_bench_press"
        ),
        
        // REGIONE: SCHIENA
        // Esercizi a corpo libero per la schiena
        Exercise(
            name = "Superman",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Glutes", "Lower back"),
            requiredTools = emptyList(),
            description = "Sdraiati a pancia in giù con le braccia tese in avanti. Solleva contemporaneamente braccia e gambe dal pavimento.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "superman"
        ),
        Exercise(
            name = "Bird Dog",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Core", "Glutes"),
            requiredTools = emptyList(),
            description = "In posizione quadrupedica, estendi contemporaneamente un braccio e la gamba opposta. Mantieni la posizione per 2 secondi.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "bird_dog"
        ),
        Exercise(
            name = "Back Extension",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Glutes", "Lower back"),
            requiredTools = emptyList(),
            description = "Sdraiati a pancia in giù con le mani dietro la testa. Solleva il busto dal pavimento contraendo i muscoli della schiena.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "back_extension"
        ),
        Exercise(
            name = "Pull-ups",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con le mani alla larghezza delle spalle, tira il corpo verso l'alto fino a che il mento supera la barra, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "pull_up"
        ),
        Exercise(
            name = "Chin-ups",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con i palmi rivolti verso di te, tira il corpo verso l'alto fino a che il mento supera la barra, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "chin_up"
        ),
        
        // Esercizi con manubri per la schiena
        Exercise(
            name = "Dumbbell Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Appoggia un ginocchio e una mano su una panca, afferra un manubrio con l'altra mano. Tira il manubrio verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_row"
        ),
        Exercise(
            name = "Reverse Flyes",
            primaryMuscleGroup = "Rear Deltoids",
            secondaryMuscleGroups = listOf("Upper Back"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi piegato in avanti con un manubrio in ogni mano, solleva le braccia ai lati fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "reverse_flyes"
        ),
        
        // Esercizi con bilanciere per la schiena
        Exercise(
            name = "Barbell Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, piegati in avanti e afferra il bilanciere. Tira il bilanciere verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "barbell_row"
        ),
        Exercise(
            name = "Good Morning",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Hamstrings", "Glutes"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con il bilanciere sulle spalle, piegati in avanti mantenendo la schiena dritta, poi torna alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "good_morning"
        ),
        
        // Esercizi con macchine per la schiena
        Exercise(
            name = "Lat Pulldown",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "Seduto alla macchina, afferra la barra con le mani alla larghezza delle spalle. Tira la barra verso il petto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "lat_pulldown"
        ),
        Exercise(
            name = "Cable Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "Seduto alla macchina, afferra la barra o le maniglie. Tira verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "cable_row"
        ),
        Exercise(
            name = "Face Pull",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Shoulders", "Rear Deltoids"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fronte a un cavo alto, afferra la corda o la barra. Tira verso il viso separando le estremità, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "face_pull"
        ),
        
        // REGIONE: GAMBE
        // Esercizi a corpo libero per le gambe
        Exercise(
            name = "Bodyweight Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "In piedi con i piedi alla larghezza delle spalle. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "bodyweight_squat"
        ),
        Exercise(
            name = "Jump Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui uno squat e poi esplodi verso l'alto saltando. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "jump_squat"
        ),
        Exercise(
            name = "Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "Fai un passo in avanti e abbassa il ginocchio posteriore verso il pavimento. Spingi con la gamba anteriore per tornare alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "lunge"
        ),
        Exercise(
            name = "Jumping Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui un affondo e poi salta cambiando la posizione delle gambe in aria. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "jumping_lunge"
        ),
        Exercise(
            name = "Wall Sit",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes"),
            requiredTools = emptyList(),
            description = "Appoggia la schiena al muro e abbassa il corpo fino a formare un angolo di 90 gradi con le ginocchia. Mantieni la posizione.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "wall_sit"
        ),
        
        // Esercizi con manubri per le gambe
        Exercise(
            name = "Dumbbell Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, fai un passo in avanti e abbassa il ginocchio posteriore verso il pavimento. Spingi con la gamba anteriore per tornare alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_lunge"
        ),
        Exercise(
            name = "Dumbbell Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con i piedi alla larghezza delle spalle e un manubrio in ogni mano. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_squat"
        ),
        Exercise(
            name = "Goblet Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells", "Kettlebell"),
            description = "In piedi con i piedi alla larghezza delle spalle, tieni un manubrio o un kettlebell davanti al petto. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "goblet_squat"
        ),
        Exercise(
            name = "Calf Raises",
            primaryMuscleGroup = "Calves",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con i piedi alla larghezza delle spalle e un manubrio in ogni mano, solleva i talloni dal pavimento, poi abbassali lentamente.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "calf_raise"
        ),
        Exercise(
            name = "Bulgarian Split Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un piede su una panca dietro di te e un manubrio in ogni mano. Abbassa il ginocchio posteriore verso il pavimento, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "bulgarian_split_squat"
        ),
        
        // Esercizi con bilanciere per le gambe
        Exercise(
            name = "Barbell Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Posiziona il bilanciere sulle spalle. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "barbell_squat"
        ),
        Exercise(
            name = "Romanian Deadlift",
            primaryMuscleGroup = "Hamstrings",
            secondaryMuscleGroups = listOf("Glutes", "Back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, afferra il bilanciere. Mantenendo la schiena dritta, piegati in avanti spingendo i glutei indietro, poi torna alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "romanian_deadlift"
        ),
        Exercise(
            name = "Hip Thrust",
            primaryMuscleGroup = "Glutes",
            secondaryMuscleGroups = listOf("Hamstrings", "Lower back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati con la schiena su una panca e il bilanciere sulle anche. Spingi i glutei verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "hip_thrust"
        ),
        
        // Esercizi con macchine per le gambe
        Exercise(
            name = "Leg Press",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Leg Press Machine"),
            description = "Seduto alla macchina, posiziona i piedi sulla piattaforma. Spingi la piattaforma lontano da te estendendo le gambe, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "leg_press"
        ),
        Exercise(
            name = "Seated Calf Raises",
            primaryMuscleGroup = "Calves",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Calf Raise Machine"),
            description = "Seduto alla macchina, posiziona i piedi sulla piattaforma. Solleva i talloni, poi abbassali lentamente.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "seated_calf_raise"
        ),
        Exercise(
            name = "Leg Extensions",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Leg Extension Machine"),
            description = "Seduto alla macchina, posiziona le gambe sotto il rullo. Estendi le gambe, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "leg_extension"
        ),
        Exercise(
            name = "Leg Curls",
            primaryMuscleGroup = "Hamstrings",
            secondaryMuscleGroups = listOf("Calves"),
            requiredTools = listOf("Leg Curl Machine"),
            description = "Sdraiati sulla macchina con le gambe sotto il rullo. Piega le ginocchia avvicinando i talloni ai glutei, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "leg_curl"
        ),
        
        // REGIONE: SPALLE
        // Esercizi con manubri per le spalle
        Exercise(
            name = "Dumbbell Shoulder Press",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Upper Chest"),
            requiredTools = listOf("Dumbbells"),
            description = "Seduto o in piedi con un manubrio in ogni mano all'altezza delle spalle. Spingi i manubri verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_shoulder_press"
        ),
        Exercise(
            name = "Lateral Raises",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Traps"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, solleva le braccia ai lati fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "lateral_raise"
        ),
        Exercise(
            name = "Front Raises",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Chest"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, solleva le braccia in avanti fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "front_raise"
        ),
        Exercise(
            name = "Arnold Press",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Upper Chest"),
            requiredTools = listOf("Dumbbells"),
            description = "Seduto o in piedi con un manubrio in ogni mano all'altezza delle spalle con i palmi rivolti verso di te. Ruota i polsi mentre spingi i manubri verso l'alto, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "arnold_press"
        ),
        
        // Esercizi con bilanciere per le spalle
        Exercise(
            name = "Barbell Shoulder Press",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Upper Chest"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Seduto o in piedi con il bilanciere all'altezza delle spalle. Spingi il bilanciere verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "barbell_shoulder_press"
        ),
        Exercise(
            name = "Upright Row",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Traps", "Biceps"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con il bilanciere davanti alle cosce, tira il bilanciere verso l'alto lungo il corpo fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "upright_row"
        ),
        
        // REGIONE: BRACCIA
        // Esercizi con manubri per le braccia
        Exercise(
            name = "Dumbbell Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, curla i manubri verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dumbbell_curl"
        ),
        Exercise(
            name = "Hammer Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano con i palmi rivolti l'uno verso l'altro, curla i manubri verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "hammer_curl"
        ),
        Exercise(
            name = "Tricep Extension",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi o seduto con un manubrio in ogni mano, solleva le braccia sopra la testa. Abbassa i manubri dietro la testa piegando i gomiti, poi estendi le braccia.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "tricep_extension"
        ),
        Exercise(
            name = "Wrist Curl",
            primaryMuscleGroup = "Forearms",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells", "Barbell"),
            description = "Seduto con gli avambracci appoggiati sulle cosce, afferra un manubrio o un bilanciere con i palmi rivolti verso l'alto. Curla il peso verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "wrist_curl"
        ),
        Exercise(
            name = "Reverse Wrist Curl",
            primaryMuscleGroup = "Forearms",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells", "Barbell"),
            description = "Seduto con gli avambracci appoggiati sulle cosce, afferra un manubrio o un bilanciere con i palmi rivolti verso il basso. Curla il peso verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "reverse_wrist_curl"
        ),
        
        // Esercizi con bilanciere per le braccia
        Exercise(
            name = "Barbell Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, afferra il bilanciere con i palmi rivolti in avanti. Curla il bilanciere verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "barbell_curl"
        ),
        Exercise(
            name = "Preacher Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Barbell", "Weight Plates", "Preacher Bench"),
            description = "Seduto alla panca preacher con i gomiti appoggiati, afferra il bilanciere con i palmi rivolti in avanti. Curla il bilanciere verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "preacher_curl"
        ),
        Exercise(
            name = "Skull Crushers",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca con il bilanciere sopra la testa. Abbassa il bilanciere dietro la testa piegando i gomiti, poi estendi le braccia.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "skull_crushers"
        ),
        
        // Esercizi con macchine per le braccia
        Exercise(
            name = "Tricep Pushdown",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fronte a un cavo alto, afferra la barra o la corda con i palmi rivolti verso il basso. Estendi le braccia verso il basso, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "tricep_pushdown"
        ),
        
        // Esercizi a corpo libero per le braccia
        Exercise(
            name = "Dips",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf("Chest", "Shoulders"),
            requiredTools = listOf("Parallel Bars"),
            description = "Appeso alle parallele con le braccia tese, abbassa il corpo piegando i gomiti, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "dips"
        ),
        Exercise(
            name = "Bench Dips",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf("Chest", "Shoulders"),
            requiredTools = listOf("Bench"),
            description = "Seduto su una panca con le mani ai lati, abbassa il corpo piegando i gomiti, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "bench_dips"
        ),
        
        // REGIONE: CORE
        // Esercizi a corpo libero per il core
        Exercise(
            name = "Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = emptyList(),
            description = "In posizione di plank con gli avambracci a terra. Mantieni il corpo in linea retta contraendo gli addominali.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "plank"
        ),
        Exercise(
            name = "Side Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Appoggia un avambraccio a terra e solleva il corpo lateralmente. Mantieni la posizione con il corpo in linea retta.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "side_plank"
        ),
        Exercise(
            name = "Russian Twists",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Siediti con le ginocchia piegate e i piedi sollevati. Ruota il busto da un lato all'altro toccando il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "russian_twist"
        ),
        Exercise(
            name = "Leg Raises",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le gambe tese. Solleva le gambe fino a 90 gradi e abbassale lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "leg_raise"
        ),
        Exercise(
            name = "Bicycle Crunches",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le mani dietro la testa. Porta il gomito destro verso il ginocchio sinistro e viceversa.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "bicycle_crunch"
        ),
        Exercise(
            name = "Hanging Leg Raise",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con le braccia tese, solleva le gambe tese fino a 90 gradi, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "hanging_leg_raise"
        ),
        Exercise(
            name = "Dragon Flag",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Bench"),
            description = "Sdraiati su una panca con le mani che afferrano la panca dietro la testa. Solleva il corpo mantenendo le gambe tese, poi controlla il ritorno.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "dragon_flag"
        ),
        
        // Esercizi con attrezzi per il core
        Exercise(
            name = "Cable Woodchop",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alto, afferra la maniglia con entrambe le mani. Ruota il busto tirando la maniglia verso il ginocchio opposto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "cable_woodchop"
        ),
        Exercise(
            name = "Cable Crunch",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Cable Machine"),
            description = "In ginocchio di fronte a un cavo alto, afferra la corda con le mani dietro la testa. Crunch verso il basso contraendo gli addominali, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "cable_crunch"
        ),
        Exercise(
            name = "Ab Wheel Rollout",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Ab Wheel"),
            description = "In ginocchio con le mani sulla ruota, rotola la ruota in avanti estendendo le braccia, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "ab_wheel_rollout"
        ),
        Exercise(
            name = "Pallof Press",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alla media altezza, afferra la maniglia con entrambe le mani. Premi la maniglia in avanti mantenendo il busto fermo, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "pallof_press"
        ),
        Exercise(
            name = "Cable Rotation",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alla media altezza, afferra la maniglia con entrambe le mani. Ruota il busto tirando la maniglia attraverso il corpo, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "cable_rotation"
        ),
        Exercise(
            name = "Weighted Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Weight Plates"),
            description = "In posizione di plank con gli avambracci a terra, posiziona un peso sulla schiena. Mantieni la posizione contraendo gli addominali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "weighted_plank"
        ),
        Exercise(
            name = "Weighted Sit-up",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = listOf("Dumbbells", "Weight Plates"),
            description = "Sdraiati sulla schiena con le ginocchia piegate e un peso sul petto. Solleva il busto verso le ginocchia, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "weighted_situp"
        ),
        Exercise(
            name = "Weighted Russian Twist",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = listOf("Dumbbells", "Weight Plates"),
            description = "Siediti con le ginocchia piegate e i piedi sollevati, tieni un peso davanti al petto. Ruota il busto da un lato all'altro toccando il peso al pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "weighted_russian_twist"
        ),
        
        // REGIONE: CARDIO
        // Esercizi cardio
        Exercise(
            name = "Kettlebell Swing",
            primaryMuscleGroup = "Hamstrings",
            secondaryMuscleGroups = listOf("Glutes", "Back", "Shoulders"),
            requiredTools = listOf("Kettlebell"),
            description = "In piedi con i piedi alla larghezza delle spalle, afferra il kettlebell con entrambe le mani. Oscilla il kettlebell tra le gambe e poi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "kettlebell_swing"
        ),
    )
}
