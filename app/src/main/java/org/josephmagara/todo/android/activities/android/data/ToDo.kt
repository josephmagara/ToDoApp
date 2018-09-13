package org.josephmagara.todo.android.activities.android.data

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

data class ToDo(var title: String, var subtasks: MutableLiveData<List<SubTask>>) : ViewModel() {

  private var todoCompleted: Boolean = false
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subtasks aren't
  private val completed: Boolean
    get(){

    if (userHasDecidedToComplete) return todoCompleted

      subtasks.let {
        for (task in subtasks.value!!){
          if (!task.completed){
            return false
          }
        }
      }

    return todoCompleted
  }

  fun setUserHasDecidedToComplete(isComplete: Boolean){
    userHasDecidedToComplete = isComplete
  }

  fun setToDoCompleted(isComplete: Boolean){
    todoCompleted = isComplete
  }

}