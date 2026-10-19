package com.example.pam5.latihan2.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Latihan 2 (Screen 1: NIM, Nama, Text "Screen 1", Tombol "Ke Halaman 2")
@Composable
fun Latihan2FirstScreen(
    nim: String,
    nama: String,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "NIM  : $nim")
        Text(text = "Nama : $nama")

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Screen 1")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ke Halaman 2")
        }
    }
}
