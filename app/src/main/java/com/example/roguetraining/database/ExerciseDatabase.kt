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
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Diamond Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani a forma di diamante sotto il petto. Esegui i push-up mantenendo i gomiti vicini al corpo.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_diamond_push_ups-side"
        ),
        Exercise(
            name = "Incline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani su una superficie rialzata (panca o gradino). Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_bodyweight_incline_push_up_side"
        ),
        Exercise(
            name = "Decline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona i piedi su una superficie rialzata. Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "male_bodyweight_decline_push_up_side"
        ),
        Exercise(
            name = "Pike Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In posizione di plank, solleva i glutei formando una V rovesciata. Piega i gomiti abbassando la testa verso il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_bodyweight_pike_press_side"
        ),

        /* TOO NICHE-ISH
        Exercise(
            name = "Handstand Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In verticale contro il muro, abbassa il corpo piegando i gomiti e poi spingi verso l'alto.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "X"
        ),
        */
        
        // Esercizi con manubri per il petto
        Exercise(
            name = "Dumbbell Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca con un manubrio in ogni mano. Spingi i manubri verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbell_bench_press_side_rqe1ite"
        ),
        Exercise(
            name = "Incline Dumbbell Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca inclinata con un manubrio in ogni mano. Spingi i manubri verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbell_incline_bench_press_side_2hbfn3"
        ),
        Exercise(
            name = "Dumbbell Flyes",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Sdraiati su una panca con un manubrio in ogni mano. Con le braccia leggermente piegate, abbassa i manubri ai lati e poi sollevali verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbell_chest_fly_side"
        ),

        // Esercizi con bilanciere per il petto
        Exercise(
            name = "Barbell Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca con il bilanciere sopra il petto. Abbassa il bilanciere al petto e poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_bench_press_side_kciuhbb"
        ),
        Exercise(
            name = "Incline Barbell Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca reclinata con il bilanciere sopra il petto. Abbassa il bilanciere al petto e poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_incline_bench_press_side"
        ),

        // Esercizi con macchine per il petto
        Exercise(
            name = "Cable Flyes",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi tra due cavi, afferra le maniglie con le braccia leggermente piegate. Porta le braccia in avanti e insieme come per abbracciare un albero.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_cable_pec_fly_front"
        ),
        Exercise(
            name = "Machine Chest Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Chest Press Machine"),
            description = "Seduto alla macchina, afferra le maniglie. Spingi le maniglie in avanti estendendo le braccia, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_machine_machine_chest_press_side"
        ),
        Exercise(
            name = "Smith Machine Bench Press",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = listOf("Smith Machine"),
            description = "Sdraiati su una panca sotto la Smith Machine. Afferra il bilanciere e abbassalo al petto, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_smithmachine_bench_press_side"
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
            videoResource = "male_bodyweight_supermans_side"
        ),
        Exercise(
            name = "Bird Dog",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Core", "Glutes"),
            requiredTools = emptyList(),
            description = "In posizione quadrupedica, estendi contemporaneamente un braccio e la gamba opposta. Mantieni la posizione per 2 secondi.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_bodyweight_bird_dog_side"
        ),
        Exercise(
            name = "Back Extension",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Glutes", "Lower back"),
            requiredTools = emptyList(),
            description = "Sdraiati a pancia in giù. Solleva il busto dal pavimento contraendo i muscoli della schiena.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_recovery_lower_back_extensions_2_front"
        ),
        Exercise(
            name = "Pull-ups",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con le mani alla larghezza delle spalle, tira il corpo verso l'alto fino a che il mento supera la barra, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_pullup_side"
        ),
        Exercise(
            name = "Chin-ups",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con i palmi rivolti verso di te, tira il corpo verso l'alto fino a che il mento supera la barra, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_chinup_side"
        ),

        // Esercizi con manubri per la schiena
        Exercise(
            name = "Dumbbell Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Dumbbells"),
            description = "Appoggia un ginocchio e una mano su una panca, afferra un manubrio con l'altra mano. Tira il manubrio verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_kneeling_single_arm_row_side"
        ),
        Exercise(
            name = "Reverse Flyes",
            primaryMuscleGroup = "Rear Deltoids",
            secondaryMuscleGroups = listOf("Upper Back"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi piegato in avanti con un manubrio in ogni mano, solleva le braccia ai lati fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_rear_delt_fly_side"
        ),




        // Esercizi con bilanciere per la schiena
        Exercise(
            name = "Barbell Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, piegati in avanti e afferra il bilanciere. Tira il bilanciere verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_pronated_row_side"
        ),
        Exercise(
            name = "Good Morning",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Hamstrings", "Glutes"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con il bilanciere sulle spalle, piegati in avanti mantenendo la schiena dritta, poi torna alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_low_bar_good_morning_side"
        ),

        // Esercizi con macchine per la schiena
        Exercise(
            name = "Lat Pulldown",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "Seduto alla macchina, afferra la barra con le mani alla larghezza delle spalle. Tira la barra verso il petto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_machine_pulldown_front"
        ),
        Exercise(
            name = "Cable Row",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Biceps", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "Seduto alla macchina, afferra la barra o le maniglie. Tira verso l'addome, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_machine_seated_cable_row_front"
        ),
        Exercise(
            name = "Face Pull",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Shoulders", "Rear Deltoids"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fronte a un cavo alto, afferra la corda o la barra. Tira verso il viso separando le estremità, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_machine_machine_face_pulls_side"
        ),

        //GIF CONTINUE

        // REGIONE: GAMBE
        // Esercizi a corpo libero per le gambe
        Exercise(
            name = "Bodyweight Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "In piedi con i piedi alla larghezza delle spalle. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_bodyweight_jump_squats_front"
        ),
        Exercise(
            name = "Jump Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui uno squat e poi esplodi verso l'alto saltando. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_bodyweight_alternating_jump_lunge_side"
        ),
        Exercise(
            name = "Forward Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "Fai un passo in avanti e abbassa il ginocchio posteriore verso il pavimento. Spingi con la gamba anteriore per tornare alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_forward_lunges_side"
        ),
        Exercise(
            name = "Jumping Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui un affondo e poi salta cambiando la posizione delle gambe in aria. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "male_bodyweight_jump_squats_front"
        ),
        Exercise(
            name = "Wall Sit",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes"),
            requiredTools = emptyList(),
            description = "Appoggia la schiena al muro e abbassa il corpo fino a formare un angolo di 90 gradi con le ginocchia. Mantieni la posizione.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_wall_sit_side"
        ),

        // Esercizi con manubri per le gambe
        Exercise(
            name = "Dumbbell Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, fai un passo in avanti e abbassa il ginocchio posteriore verso il pavimento. Spingi con la gamba anteriore per tornare alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_forward_lunge_side"
        ),
        /* NO GIF
        Exercise(
            name = "Dumbbell Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con i piedi alla larghezza delle spalle e un manubrio in ogni mano. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        */
        Exercise(
            name = "Goblet Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells", "Kettlebell"),
            description = "In piedi con i piedi alla larghezza delle spalle, tieni un manubrio o un kettlebell davanti al petto. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbell_goblet_squat_front"
        ),
        Exercise(
            name = "Calf Raises",
            primaryMuscleGroup = "Calves",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con i piedi alla larghezza delle spalle e un manubrio in ogni mano, solleva i talloni dal pavimento, poi abbassali lentamente.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_dumbbells_dumbbell_calf_raise_side"
        ),
        Exercise(
            name = "Bulgarian Split Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un piede su una panca dietro di te e un manubrio in ogni mano. Abbassa il ginocchio posteriore verso il pavimento, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_bulgarian_split_squat_side"
        ),

        // Esercizi con bilanciere per le gambe
        Exercise(
            name = "Barbell Squat",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Posiziona il bilanciere sulle spalle. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro, poi risali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_squat_front"
        ),
        Exercise(
            name = "Romanian Deadlift",
            primaryMuscleGroup = "Hamstrings",
            secondaryMuscleGroups = listOf("Glutes", "Back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, afferra il bilanciere. Mantenendo la schiena dritta, piegati in avanti spingendo i glutei indietro, poi torna alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_romanian_deadlift_side"
        ),
        Exercise(
            name = "Hip Thrust",
            primaryMuscleGroup = "Glutes",
            secondaryMuscleGroups = listOf("Hamstrings", "Lower back"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati con la schiena su una panca e il bilanciere sulle anche. Spingi i glutei verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_hip_thrust_front"
        ),

        // Esercizi con macchine per le gambe
        Exercise(
            name = "Leg Press",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = listOf("Leg Press Machine"),
            description = "Seduto alla macchina, posiziona i piedi sulla piattaforma. Spingi la piattaforma lontano da te estendendo le gambe, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_machine_leg_press_front"
        ),
        Exercise(
            name = "Seated Calf Raises",
            primaryMuscleGroup = "Calves",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Calf Raise Machine"),
            description = "Seduto alla macchina, posiziona i piedi sulla piattaforma. Solleva i talloni, poi abbassali lentamente.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_machine_seated_calf_raise_side"
        ),
        Exercise(
            name = "Leg Extensions",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Leg Extension Machine"),
            description = "Seduto alla macchina, posiziona le gambe sotto il rullo. Estendi le gambe, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_machine_leg_extension_front"
        ),
        Exercise(
            name = "Leg Curls",
            primaryMuscleGroup = "Hamstrings",
            secondaryMuscleGroups = listOf("Calves"),
            requiredTools = listOf("Leg Curl Machine"),
            description = "Sdraiati sulla macchina con le gambe sotto il rullo. Piega le ginocchia avvicinando i talloni ai glutei, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_machine_hamstring_curl_side"
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
            videoResource = "male_dumbbell_seated_overhead_press_side"
        ),
        Exercise(
            name = "Lateral Raises",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Traps"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, solleva le braccia ai lati fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_lateral_raise_side"
        ),
        Exercise(
            name = "Front Raises",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Chest"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano, solleva le braccia in avanti fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_front_raise_front"
        ),
        Exercise(
            name = "Arnold Press",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Upper Chest"),
            requiredTools = listOf("Dumbbells"),
            description = "Seduto o in piedi con un manubrio in ogni mano all'altezza delle spalle con i palmi rivolti verso di te. Ruota i polsi mentre spingi i manubri verso l'alto, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_seated_arnold_press_front"
        ),

        // Esercizi con bilanciere per le spalle
        Exercise(
            name = "Barbell Shoulder Press",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Upper Chest"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Seduto o in piedi con il bilanciere all'altezza delle spalle. Spingi il bilanciere verso l'alto estendendo le braccia, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_overhead_press_side"
        ),
        Exercise(
            name = "Upright Row",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Upper Traps", "Biceps"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con il bilanciere davanti alle cosce, tira il bilanciere verso l'alto lungo il corpo fino all'altezza delle spalle, poi abbassa lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_upright_row_side"
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
            videoResource = "male_dumbbells_dumbbell_curl_side"
        ),
        Exercise(
            name = "Hammer Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi con un manubrio in ogni mano con i palmi rivolti l'uno verso l'altro, curla i manubri verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_hammer_curl_side"
        ),
        Exercise(
            name = "Tricep Extension",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells"),
            description = "In piedi o seduto con un manubrio o due, solleva le braccia sopra la testa. Abbassa i manubri dietro la testa piegando i gomiti, poi estendi le braccia.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_dumbbells_dumbbell_seated_overhead_tricep_extension_side"
        ),
        Exercise(
            name = "Wrist Curl",
            primaryMuscleGroup = "Forearms",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells", "Barbell"),
            description = "Seduto con gli avambracci appoggiati sulle cosce, afferra un manubrio o un bilanciere con i palmi rivolti verso l'alto. Curla il peso verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "male_dumbbells_dumbbell_wrist_curl_side"
        ),
        /* NO GIF
        Exercise(
            name = "Reverse Wrist Curl",
            primaryMuscleGroup = "Forearms",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Dumbbells", "Barbell"),
            description = "Seduto con gli avambracci appoggiati sulle cosce, afferra un manubrio o un bilanciere con i palmi rivolti verso il basso. Curla il peso verso l'alto, poi controlla il ritorno.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "X"
        ),
        */
        // Esercizi con bilanciere per le braccia
        Exercise(
            name = "Barbell Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "In piedi con i piedi alla larghezza delle spalle, afferra il bilanciere con i palmi rivolti in avanti. Curla il bilanciere verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_curl_side"
        ),
        Exercise(
            name = "Preacher Curl",
            primaryMuscleGroup = "Biceps",
            secondaryMuscleGroups = listOf("Forearms"),
            requiredTools = listOf("Barbell", "Weight Plates", "Preacher Bench"),
            description = "Seduto alla panca preacher con i gomiti appoggiati, afferra il bilanciere con i palmi rivolti in avanti. Curla il bilanciere verso le spalle, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_ez_bar_preacher_curl_side"
        ),
        Exercise(
            name = "Skull Crushers",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Barbell", "Weight Plates"),
            description = "Sdraiati su una panca con il bilanciere sopra la testa. Abbassa il bilanciere dietro la testa piegando i gomiti, poi estendi le braccia.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_barbell_barbell_skullcrusher_side"
        ),

        // Esercizi con macchine per le braccia
        Exercise(
            name = "Tricep Pushdown",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fronte a un cavo alto, afferra la barra o la corda con i palmi rivolti verso il basso. Estendi le braccia verso il basso, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_cables_cable_push_down_side"
        ),
        
        // Esercizi a corpo libero per le braccia
        Exercise(
            name = "Dips",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf("Chest", "Shoulders"),
            requiredTools = listOf("Parallel Bars"),
            description = "Appeso alle parallele con le braccia tese, abbassa il corpo piegando i gomiti, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_parralel_bar_dips_front"
        ),
        Exercise(
            name = "Bench Dips",
            primaryMuscleGroup = "Triceps",
            secondaryMuscleGroups = listOf("Chest", "Shoulders"),
            requiredTools = listOf("Bench"),
            description = "Seduto su una panca con le mani ai lati, abbassa il corpo piegando i gomiti, poi spingi verso l'alto.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_bench_dips_side"
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
            videoResource = "male_bodyweight_forearm_plank_side"
        ),
        Exercise(
            name = "Side Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Appoggia un avambraccio a terra e solleva il corpo lateralmente. Mantieni la posizione con il corpo in linea retta.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_hand_side_plank_front"
        ),
        Exercise(
            name = "Russian Twists",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Siediti con le ginocchia piegate e i piedi sollevati. Ruota il busto da un lato all'altro toccando il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_russian_twist_front"
        ),
        Exercise(
            name = "Leg Raises",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le gambe tese. Solleva le gambe fino a 90 gradi e abbassale lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_laying_leg_raises_front"
        ),
        Exercise(
            name = "Bicycle Crunches",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le mani dietro la testa. Porta il gomito destro verso il ginocchio sinistro e viceversa.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_bicycle_crunch_side"
        ),
        /* NO GIF
        Exercise(
            name = "Hanging Leg Raise",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = listOf("Pull-up Bar"),
            description = "Appeso alla barra con le braccia tese, solleva le gambe tese fino a 90 gradi, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),

        Exercise(
            name = "Dragon Flag",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Bench"),
            description = "Sdraiati su una panca con le mani che afferrano la panca dietro la testa. Solleva il corpo mantenendo le gambe tese, poi controlla il ritorno.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "male_bodyweight_push_up_side"
        ),
        */

        GIF CONTINUE
        
        // Esercizi con attrezzi per il core
        Exercise(
            name = "Cable Woodchop",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alto, afferra la maniglia con entrambe le mani. Ruota il busto tirando la maniglia verso il ginocchio opposto, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Cable Crunch",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf(),
            requiredTools = listOf("Cable Machine"),
            description = "In ginocchio di fronte a un cavo alto, afferra la corda con le mani dietro la testa. Crunch verso il basso contraendo gli addominali, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Ab Wheel Rollout",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Ab Wheel"),
            description = "In ginocchio con le mani sulla ruota, rotola la ruota in avanti estendendo le braccia, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Pallof Press",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alla media altezza, afferra la maniglia con entrambe le mani. Premi la maniglia in avanti mantenendo il busto fermo, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Cable Rotation",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques", "Shoulders"),
            requiredTools = listOf("Cable Machine"),
            description = "In piedi di fianco a un cavo alla media altezza, afferra la maniglia con entrambe le mani. Ruota il busto tirando la maniglia attraverso il corpo, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Weighted Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = listOf("Weight Plates"),
            description = "In posizione di plank con gli avambracci a terra, posiziona un peso sulla schiena. Mantieni la posizione contraendo gli addominali.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Weighted Sit-up",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = listOf("Dumbbells", "Weight Plates"),
            description = "Sdraiati sulla schiena con le ginocchia piegate e un peso sul petto. Solleva il busto verso le ginocchia, poi controlla il ritorno.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
        ),
        Exercise(
            name = "Weighted Russian Twist",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = listOf("Dumbbells", "Weight Plates"),
            description = "Siediti con le ginocchia piegate e i piedi sollevati, tieni un peso davanti al petto. Ruota il busto da un lato all'altro toccando il peso al pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "male_bodyweight_push_up_side"
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
            videoResource = "male_bodyweight_push_up_side"
        ),
    )
}
