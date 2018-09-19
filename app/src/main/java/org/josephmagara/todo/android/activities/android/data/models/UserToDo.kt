package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user_to_do")
data class UserToDo(var title: String, @PrimaryKey var dateCreated: Date, var dateDue: Date,
    var dateModified: Date) : ViewModel() {

  @Ignore
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subTasks aren't
  var completed: Boolean = false
    get(){

    if (userHasDecidedToComplete) return true

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