package org.josephmagara.todo.android.activities.android.data

data class ToDo(var title: String, var subtasks: List<SubTask>) {

  private var todoCompleted: Boolean = false
  private var userHasDecidedToComplete: Boolean = false
  private val completed: Boolean
    get(){
    if (userHasDecidedToComplete) return todoCompleted
    for (task in subtasks){
      if (!task.completed){
        return false
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