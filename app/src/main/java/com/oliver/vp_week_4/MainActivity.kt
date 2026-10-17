package com.oliver.vp_week_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.oliver.vp_week_4.Soal2.Soal2View
import com.oliver.vp_week_4.ui.theme.VPWeek4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VPWeek4Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Soal2View()
                }
            }
        }
    }
}
