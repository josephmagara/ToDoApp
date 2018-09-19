package org.josephmagara.todo.android.activities.android.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity(tableName = "sub_tasks")
data class SubTask(var title: String, var parentUserToDoId: Int, @PrimaryKey var dateSubTaskCreated: Date, var dateDue: Date, var completed: Boolean)