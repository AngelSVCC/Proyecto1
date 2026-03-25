package com.example.actividad1_proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.room.Room
import com.example.actividad1_proyecto1.data.AppDatabase
import com.example.actividad1_proyecto1.ui.TaskApp
import com.example.actividad1_proyecto1.ui.theme.Actividad1Proyecto1Theme
import com.example.actividad1_proyecto1.domain.TaskRepositoryImpl
import com.example.actividad1_proyecto1.data.TaskViewModel
import com.example.actividad1_proyecto1.data.TaskViewModelFactory
import kotlin.getValue


class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_db"
        ).build()
    }

    private val repository by lazy {
        TaskRepositoryImpl(db.taskDao())
    }

    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Actividad1Proyecto1Theme {
                TaskApp(viewModel)
            }
        }
    }
}