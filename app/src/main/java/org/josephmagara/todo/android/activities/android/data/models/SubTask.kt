package org.josephmagara.todo.android.activities.android.data.models

import android.arch.persistence.room.Entity
import java.util.Date

@Entity(primaryKeys = ["dateCreated"])
data class SubTask(private val title: String, private val dateCreated: Date, val completed: Boolean)