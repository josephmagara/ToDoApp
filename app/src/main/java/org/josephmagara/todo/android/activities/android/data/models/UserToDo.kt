package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity
data class UserToDo(var ignore: String) : ViewModel() {

  @PrimaryKey
  var dateCreated = Date()
  var dateDue = Date()
  var dateModified = Date()
  @Embedded(prefix = "usr_subtask_")
  var subTasks: MutableLiveData<MutableList<SubTask>> = MutableLiveData()

  var title : String = ""
  @Ignore
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subTasks aren't
  var completed: Boolean = false
    get(){

    if (userHasDecidedToComplete) return true

      subTasks.let {
        if (subTasks.value?.size == 0 || subTasks.value == null) return userHasDecidedToComplete
        for (task in subTasks.value!!){
          if (!task.completed){
            return false
          }
        }
      }

    return userHasDecidedToComplete
  }

  constructor(passedTitle: String, passedSubtasks: MutableLiveData<MutableList<SubTask>>, dateCreated: Date, dateDue: Date) : this("") {
    this.title = passedTitle
    this.subTasks = passedSubtasks
    this.dateCreated = dateCreated
    this.dateDue = dateDue
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