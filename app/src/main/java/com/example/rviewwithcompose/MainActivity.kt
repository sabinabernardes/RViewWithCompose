package com.example.rviewwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rviewwithcompose.ui.theme.RViewWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RViewWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp {
                        startActivity(ProfileActivity.newIntent(this, it))
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (Puppy) -> Unit) {
    Scaffold(
        content = {
            BarkHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}
