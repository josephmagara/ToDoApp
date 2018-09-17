package org.josephmagara.todo.android.activities.android.data.models

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Entity
import android.text.format.DateUtils
import java.util.Date

@Entity(tableName = "user_to_do_table")
data class UserToDo(private var ignore: String) : ViewModel() {


  var title : String = ""
  private var dateCreated: Date? = null
  private var subtasks: MutableLiveData<MutableList<SubTask>> = MutableLiveData()
  private var todoCompleted: Boolean = false
  private var userHasDecidedToComplete: Boolean = false //The user has decided that the task is complete even if the subtasks aren't
  val completed: Boolean
    get(){

    return todoCompleted

      /*subtasks.let {
        if (subtasks.value?.size == 0) return todoCompleted
        for (task in subtasks.value!!){
          if (!task.completed){
            return false
          }
        }
      }

    return todoCompleted*/
  }

  constructor(passedTitle: String, passedSubtasks: MutableLiveData<MutableList<SubTask>>, dateCreated: Date) : this("") {
    this.title = passedTitle
    this.subtasks = passedSubtasks
    this.dateCreated = dateCreated
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