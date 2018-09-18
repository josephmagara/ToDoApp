package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.PrimaryKey
import java.util.Date

data class UserToDo(private var ignore: String) : ViewModel() {

  @PrimaryKey
  private var dateCreated = Date()
  private var dateDue = Date()
  private var dateModified = Date()
  @Embedded(prefix = "USR_")
  private var subTasks: MutableLiveData<MutableList<SubTask>> = MutableLiveData()

  var title : String = ""
  private var todoCompleted: Boolean = false
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subTasks aren't
  var completed: Boolean = false
    get(){

    if (userHasDecidedToComplete) return todoCompleted

      subTasks.let {
        if (subTasks.value?.size == 0 || subTasks.value == null) return todoCompleted
        for (task in subTasks.value!!){
          if (!task.completed){
            return false
          }
        }
      }

    return todoCompleted
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

  fun setToDoCompleted(isComplete: Boolean){
    todoCompleted = isComplete
  }

  fun getFormattedDateString(): String{
    return dateCreated.toString()
  }
}