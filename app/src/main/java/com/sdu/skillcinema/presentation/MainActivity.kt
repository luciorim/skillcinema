package com.sdu.skillcinema.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sdu.skillcinema.presentation.movie_collection.MovieCollectionScreen
import com.sdu.skillcinema.presentation.onboarding.OnboardingScreen
import com.sdu.skillcinema.presentation.navigation.MainScreen
import com.sdu.skillcinema.presentation.ui.theme.SkillcinemaTheme
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
