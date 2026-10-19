package com.example.pam5.tugas3.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pam5.tugas3.model.fruitList
import com.example.pam5.tugas3.ui.component.CatalogItem

// Tugas 3 (LazyColumn dengan stickyHeader berisi NIM dan Nama)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatalogScreen(
    nim: String,
    nama: String,
    onBackClick: () -> Unit
) {
    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "NIM : $nim",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Nama : $nama",
                        style = MaterialTheme.typography.titleMedium
                    )
                    TextButton(onClick = onBackClick) {
                        Text("← Kembali")
                    }
                }
            }

            items(fruitList, key = { it.id }) { fruit ->
                CatalogItem(fruit)
            }
        }
    }
}
