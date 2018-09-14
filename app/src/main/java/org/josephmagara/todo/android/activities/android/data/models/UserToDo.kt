package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Entity

@Entity(tableName = "user_to_do_table")
data class UserToDo() : ViewModel() {


  private var title = title
  private var subtasks = subtasks
  private var todoCompleted: Boolean = false
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subtasks aren't
  private val completed: Boolean
    get(){

    if (userHasDecidedToComplete) return todoCompleted

      subtasks.let {
        if (subtasks.value?.size == 0) return todoCompleted
        for (task in subtasks.value!!){
          if (!task.completed){
            return false
          }
        }
      }

    return todoCompleted
  }

  constructor(passedTitle: String, passedSubtasks: MutableLiveData<MutableList<SubTask>>) : this() {
    this.title = passedTitle
    this.subtasks = passedSubtasks
  }

  fun setUserHasDecidedToComplete(isComplete: Boolean){
    userHasDecidedToComplete = isComplete
  }

  fun setToDoCompleted(isComplete: Boolean){
    todoCompleted = isComplete
  }

}