package com.example.actividad1_proyecto1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.actividad1_proyecto1.data.AppDatabase
import com.example.actividad1_proyecto1.data.TaskEntity
import com.example.actividad1_proyecto1.ui.TaskApp
import com.example.actividad1_proyecto1.ui.theme.Actividad1Proyecto1Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_db"
        ).build()

        val dao = db.taskDao()

        lifecycleScope.launch {
            dao.insertTask(TaskEntity(title = "Prueba 1"))
            val items = dao.getTasks()
            Log.d("ROOM", "Tareas almacenadas: $items")
        }

        setContent {
            TaskApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    Actividad1Proyecto1Theme {
        TaskApp()
    }
}