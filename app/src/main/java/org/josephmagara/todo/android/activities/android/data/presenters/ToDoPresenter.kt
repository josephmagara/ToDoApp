package org.josephmagara.todo.android.activities.android.data.presenters

import android.arch.lifecycle.MutableLiveData
import org.josephmagara.todo.android.activities.android.data.database.DbManager
import org.josephmagara.todo.android.activities.android.data.interfaces.ListDisplayImpl
import org.josephmagara.todo.android.activities.android.data.interfaces.ToDoPresenterImpl
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import java.util.Date

class ToDoPresenter : ToDoPresenterImpl {

  private var dbManager : DbManager? = null
  private var display: ListDisplayImpl? = null

  private var list: ArrayList<UserToDo> = arrayListOf()

  fun toggleComplete(item: UserToDo){
    val value = !item.completed
    item.setUserHasDecidedToComplete(value)
    item.setToDoCompleted(value)
  }

  fun createToDo(title: String) {
    val newSubTasks = MutableLiveData<MutableList<SubTask>>()
    val newTodo = UserToDo(title,
        newSubTasks, Date(), Date())
    addTodo(newTodo)
  }

  private fun addTodo(td: UserToDo) {
    list.add(td)
    dbManager?.saveUserToDo(td)
    notifyDisplayOfDataChange()
  }

  private fun notifyDisplayOfDataChange(){
    display?.notifyAdapterOfDataChange()
  }

  override fun getAllToDos(): ArrayList<UserToDo> {
    consolidateToDos()
    return list
  }

  private fun consolidateToDos() {
    val savedToDos = dbManager?.getAllUserToDo()
    savedToDos?.let { list.addAll(it) }
    list = ArrayList(list.distinct())
  }


  override fun inject(display: ListDisplayImpl) {
    this.display = display
    dbManager = DbManager(display.getContext())
  }
}