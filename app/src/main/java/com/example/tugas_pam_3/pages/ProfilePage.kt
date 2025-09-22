package com.example.tugas_pam_3.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas_pam_3.UserData

@Composable
fun ProfilePage(
    onNavigateToAvatar: () -> Unit = {},
    onLogout: () -> Unit = {},
    userData: UserData
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 80.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Profil User", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Gunakan Card untuk tampilan lebih rapi
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                ProfileItem("First Name", userData.firstName)
                Divider()
                ProfileItem("Last Name", userData.lastName)
                Divider()
                ProfileItem("Username", userData.username)
                Divider()
                ProfileItem("Email", userData.email)
                Divider()
                ProfileItem("Phone Number", userData.phoneNumber)
                Divider()
                ProfileItem("Address", userData.address)
                Divider()
                ProfileItem("Birth Date", userData.birthDate)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Tombol ke Avatar Page
        Button(
            onClick = { onNavigateToAvatar() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Edit Avatar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Tombol Logout
        Button(
            onClick = { onLogout() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Logout")
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(label, style = MaterialTheme.typography.labelMedium)
        Text(value, style = MaterialTheme.typography.bodyLarge)
    }
}
