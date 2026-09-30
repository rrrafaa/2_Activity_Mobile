package com.example.pam5.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pam5.model.Fruit
import com.example.pam5.model.fruitList

@Composable
fun CatalogItem(fruit: Fruit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = fruit.imageRes),
                contentDescription = fruit.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = fruit.name, style = MaterialTheme.typography.titleLarge)
                Text(text = fruit.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

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