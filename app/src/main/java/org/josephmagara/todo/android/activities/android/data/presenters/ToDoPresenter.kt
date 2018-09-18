package org.josephmagara.todo.android.activities.android.data.presenters

import org.josephmagara.todo.android.activities.android.data.interfaces.ListDisplayImpl
import org.josephmagara.todo.android.activities.android.data.interfaces.ToDoPresenterImpl
import org.josephmagara.todo.android.activities.android.data.models.UserToDo

class ToDoPresenter(private val display: ListDisplayImpl): ToDoPresenterImpl {
  private var list: ArrayList<UserToDo> = arrayListOf()

  fun toggleComplete(item: UserToDo){
    item.completed = !item.completed
  }

  fun addTodo(td: UserToDo) {
    list.add(td)
    notifyDisplayOfDataChange()
  }

  fun notifyDisplayOfDataChange(){
    display.notifyAdapterOfDataChange()
  }

  override fun getAllToDos(): ArrayList<UserToDo> {
    return list
  }

}