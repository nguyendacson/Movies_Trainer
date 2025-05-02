package com.example.movies.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

@Singleton
class DataStoreManagerAuth @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_AVATAR = stringPreferencesKey("user_avatar")
    }

    val userName: Flow<String?> = context.dataStore.data.map { it[USER_NAME] }
    val userAvatar: Flow<String?> = context.dataStore.data.map { it[USER_AVATAR] }

    suspend fun saveUserName(name: String) {
        context.dataStore.edit { it[USER_NAME] = name }
    }

    suspend fun saveUserAvatar(avatar: String) {
        context.dataStore.edit { it[USER_AVATAR] = avatar }
    }

    suspend fun clearUserInfo() {
        context.dataStore.edit {
            it.remove(USER_NAME)
            it.remove(USER_AVATAR)
        }
    }
}
