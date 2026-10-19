package com.example.pam5.tugas4.ui.screen

import com.example.pam5.tugas4.viewmodel.CounterViewModel

import com.example.pam5.tugas4.ui.component.ColoredButton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pam5.ui.theme.PAM5Theme

// Tugas 4 (Screen counter: NIM, Nama, tombol Up/Down/Reset dengan ViewModel)
@Composable
fun Tugas4CounterScreen(
    nim: String,
    nama: String,
    onNextClick: () -> Unit,
    vm: CounterViewModel = viewModel()
) {
    // Mengamati state dari ViewModel
    val count by vm.count.collectAsState()

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

        Spacer(modifier = Modifier.height(16.dp))

        // Tampilan angka counter
        Text(
            text = "$count",
            textAlign = TextAlign.Right,
            fontSize = 60.sp,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, Color.Blue),
                    RoundedCornerShape(8.dp)
                )
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Down, Reset, Up
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ColoredButton(
                text = "Down",
                onClick = { vm.onClick("down") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
            ColoredButton(
                text = "Reset",
                onClick = { vm.onClick("reset") },
                containerColor = Color.Red,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
            ColoredButton(
                text = "Up",
                onClick = { vm.onClick("up") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ke Halaman 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Tugas4CounterScreenPreview() {
    PAM5Theme {
        Tugas4CounterScreen(
            nim = "245150401111035",
            nama = "Rafa Maritza Hanasaputri",
            onNextClick = {},
            vm = CounterViewModel()
        )
    }
}
