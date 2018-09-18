package org.josephmagara.todo.android.activities.android.data.models

import android.arch.persistence.room.Entity
import java.util.Date

@Entity(primaryKeys = ["dateCreated"])
data class SubTask(private var title: String, private var dateCreated: Date, private var dateDue: Date, var completed: Boolean){
  fun getTitle(): String{
    return title
  }

  fun getDateCreated(): Date{
    return dateCreated
  }

  fun getDateDue(): Date{
    return dateDue
  }
  fun getSubtaskCompleted(): Boolean{
    return completed
  }
}