package com.sdu.skillcinema

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.os.BuildCompat
import com.sdu.skillcinema.onboarding.OnboardingScreen
import com.sdu.skillcinema.navigation.MainScreen
import com.sdu.skillcinema.ui.theme.SkillcinemaTheme
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SkillcinemaTheme {
                OnboardingScreen {
                    startMainScreen()
                }
            }
        }
    }

    private fun startMainScreen() {
        setContent {
            SkillcinemaTheme {
                MainScreen()
            }
        }
    }
}
