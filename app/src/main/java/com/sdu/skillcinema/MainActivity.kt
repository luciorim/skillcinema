package com.sdu.skillcinema

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sdu.skillcinema.onboarding.OnboardingScreen
import com.sdu.skillcinema.navigation.MainScreen
import com.sdu.skillcinema.ui.theme.SkillcinemaTheme

class MainActivity : ComponentActivity() {

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)
        val onboardingComplete = preferences.getBoolean("onboarding_complete", false)

        setContent {
            SkillcinemaTheme {
                if (!onboardingComplete) {
                    OnboardingScreen {
                        completeOnboarding()
                    }
                } else {
                    MainScreen()
                }
            }
        }
    }

    private fun completeOnboarding() {
        preferences.edit().putBoolean("onboarding_complete", true).apply()
    }
}
