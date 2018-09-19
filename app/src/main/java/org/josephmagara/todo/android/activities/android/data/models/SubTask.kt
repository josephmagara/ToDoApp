package org.josephmagara.todo.android.activities.android.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity(tableName = "sub_tasks")
data class SubTask(private var title: String, @PrimaryKey private var dateCreated: Date, private var dateDue: Date, var completed: Boolean)