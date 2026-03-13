package com.ues.listadetareas.data.repository

import com.example.actividad1_proyecto1.data.TaskDao
import com.example.actividad1_proyecto1.data.TaskEntity
import com.example.actividad1_proyecto1.domain.Task
import com.ues.listadetareas.domain.TaskRepository

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return dao.getTasks().map {
            Task(
                id = it.id,
                title = it.title,
                description = it.description,
                isDone = it.isDone
            )
        }
    }

    override suspend fun addTask(task: Task) {
        dao.insertTask(
            TaskEntity(
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(
            TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(
            TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isDone = task.isDone
            )
        )
    }
}

