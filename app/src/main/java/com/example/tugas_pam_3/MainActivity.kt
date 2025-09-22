package com.example.tugas_pam_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tugas_pam_3.navigation.NavGraph
import com.example.tugas_pam_3.ui.theme.Tugas_PAM_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas_PAM_3Theme {
                NavGraph() // Memanggil file navigasi
            }
        }
    }
}
