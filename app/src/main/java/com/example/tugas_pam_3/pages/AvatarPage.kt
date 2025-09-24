package com.example.tugas_pam_3.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugas_pam_3.R

@Composable
fun AvatarPage(
    onNavigateBack: () -> Unit = {}
) {
    var showHead by remember { mutableStateOf(true) }
    var showEyes by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }
    var showEyebrows by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = { onNavigateBack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(60.dp))

        Box(
            modifier = Modifier
                .size(250.dp),
            contentAlignment = Alignment.Center
        ) {
            if (showHead) Image(
                painter = painterResource(id = R.drawable.face_0004),
                contentDescription = "Head",
                modifier = Modifier.size(400.dp)
            )
            if (showEyebrows) Image(
                painter = painterResource(id = R.drawable.face_0001),
                contentDescription = "Eyebrows",
                modifier = Modifier
                    .size(115.dp)
                    .offset(y = (-20).dp)
            )
            if (showEyes) Image(
                painter = painterResource(id = R.drawable.face_0003),
                contentDescription = "Eyes",
                modifier = Modifier
                    .size(95.dp)
            )
            if (showNose) Image(
                painter = painterResource(id = R.drawable.face_0002),
                contentDescription = "Nose",
                modifier = Modifier
                    .size(30.dp)
                    .offset(y = (25).dp)
            )
            if (showMouth) Image(
                painter = painterResource(id = R.drawable.face_0000),
                contentDescription = "Mouth",
                modifier = Modifier
                    .size(40.dp)
                    .offset(y = (50).dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showEyes, onCheckedChange = { showEyes = it })
                    Text("Mata")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showNose, onCheckedChange = { showNose = it })
                    Text("Hidung")
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showMouth, onCheckedChange = { showMouth = it })
                    Text("Mulut")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showEyebrows, onCheckedChange = { showEyebrows = it })
                    Text("Alis")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAvatarPage() {
    AvatarPage()
}