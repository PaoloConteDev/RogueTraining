package com.example.roguetraining.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class UserPreferences(private val context: Context) {
    companion object {
        private val SEX_KEY = stringPreferencesKey("sex")
        private val WEIGHT_KEY = intPreferencesKey("weight")
        private val HEIGHT_KEY = intPreferencesKey("height")
        private val AGE_KEY = intPreferencesKey("age")
    }

    val userInfo: Flow<UserInfo> = context.dataStore.data.map { preferences ->
        UserInfo(
            sex = preferences[SEX_KEY] ?: "",
            weight = preferences[WEIGHT_KEY] ?: 0,
            height = preferences[HEIGHT_KEY] ?: 0,
            age = preferences[AGE_KEY] ?: 0
        )
    }

    suspend fun saveUserInfo(userInfo: UserInfo) {
        context.dataStore.edit { preferences ->
            preferences[SEX_KEY] = userInfo.sex
            preferences[WEIGHT_KEY] = userInfo.weight
            preferences[HEIGHT_KEY] = userInfo.height
            preferences[AGE_KEY] = userInfo.age
        }
    }
}

data class UserInfo(
    val sex: String,
    val weight: Int,
    val height: Int,
    val age: Int
) 