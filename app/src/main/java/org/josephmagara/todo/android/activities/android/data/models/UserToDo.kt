package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user_to_do")
data class UserToDo(var title: String = "", @Embedded(prefix = "usr_subtask_")
var subTasks: List<SubTask>, @PrimaryKey var dateCreated: Date = Date(), var dateDue: Date = Date(),
    var dateModified: Date = Date()) : ViewModel() {

  @Ignore
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subTasks aren't
  var completed: Boolean = false
    get(){

    if (userHasDecidedToComplete) return true

      subTasks.let {
        if (subTasks.isEmpty()) return userHasDecidedToComplete
        for (task in subTasks){
          if (!task.completed){
            return false
          }
        }
      }

    return userHasDecidedToComplete
  }

  fun setUserHasDecidedToComplete(isComplete: Boolean){
    userHasDecidedToComplete = isComplete
  }

  fun getUserHasDecidedToComplete():Boolean{
    return userHasDecidedToComplete
  }

  fun getFormattedDateString(): String{
    return dateCreated.toString()
  }
}