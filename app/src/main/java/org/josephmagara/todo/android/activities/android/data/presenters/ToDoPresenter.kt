package org.josephmagara.todo.android.activities.android.data.presenters

import android.arch.lifecycle.MutableLiveData
import org.josephmagara.todo.android.activities.android.data.interfaces.ListDisplayImpl
import org.josephmagara.todo.android.activities.android.data.interfaces.ToDoPresenterImpl
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import java.util.Date

class ToDoPresenter : ToDoPresenterImpl {
  private var display: ListDisplayImpl? = null

  private var list: ArrayList<UserToDo> = arrayListOf()

  fun toggleComplete(item: UserToDo){
    val value = !item.completed
    item.setUserHasDecidedToComplete(value)
    item.setToDoCompleted(value)
  }

  fun createToDo(title: String) {
    val newSubtasks = MutableLiveData<MutableList<SubTask>>()
    val newTodo = UserToDo(title,
        newSubtasks, Date())
    addTodo(newTodo)
  }

  private fun addTodo(td: UserToDo) {
    list.add(td)
    notifyDisplayOfDataChange()
  }

  private fun notifyDisplayOfDataChange(){
    display?.notifyAdapterOfDataChange()
  }

  override fun getAllToDos(): ArrayList<UserToDo> {
    return list
  }


  override fun inject(display: ListDisplayImpl) {
    this.display = display
  }
}