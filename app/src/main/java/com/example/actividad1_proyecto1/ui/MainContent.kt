package com.example.actividad1_proyecto1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.actividad1_proyecto1.ui.screens.TaskListScreen

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        TaskListScreen()
    }
}