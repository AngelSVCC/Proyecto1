package com.ues.listadetareas.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.actividad1_proyecto1.ui.theme.GuindaUES

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = GuindaUES  // ← se agrega después en el paso 10
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            label = { Text("Pendientes") },
            icon = { Icon(Icons.Default.List, contentDescription = "Pendientes") }
        )
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            label = { Text("Completadas") },
            icon = { Icon(Icons.Default.Check, contentDescription = "Completadas") }
        )
    }
}