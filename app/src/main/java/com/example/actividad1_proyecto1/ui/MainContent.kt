package com.example.actividad1_proyecto1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.actividad1_proyecto1.domain.Task
import com.example.actividad1_proyecto1.ui.screens.TaskListScreenContent

@Composable
fun MainContent(
    tasks: List<Task>,
    onToggleDone: (Task) -> Unit,
    onEditTask: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        TaskListScreenContent(
            tasks = tasks,
            onToggleDone = onToggleDone,
            onEditTask = onEditTask
        )
    }
}