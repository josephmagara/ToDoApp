package org.josephmagara.todo.android.activities.android.data.presenters

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.josephmagara.todo.android.activities.android.data.database.DbManager
import org.josephmagara.todo.android.activities.android.data.interfaces.ListDisplayImpl
import org.josephmagara.todo.android.activities.android.data.interfaces.ToDoPresenterImpl
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import java.util.Date

class ToDoPresenter : ToDoPresenterImpl {

  private var dbManager: DbManager? = null
  private var display: ListDisplayImpl? = null

  private var list: MutableList<UserToDo> = arrayListOf()

  fun toggleComplete(item: UserToDo) {
    val value = !item.completed
    item.setUserHasDecidedToComplete(value)
  }

  fun createToDo(title: String) {
    val now = Date()
    val newTodo = UserToDo(title,
        now, now, now)
    addTodo(newTodo)
  }

  private fun addTodo(td: UserToDo) {
    //list.add(td)
    Observable.just(true)
        .observeOn(Schedulers.computation())
        .subscribe { dbManager?.saveUserToDo(td) }
    notifyDisplayOfDataChange()
  }

  private fun notifyDisplayOfDataChange() {
    display?.notifyAdapterOfDataChange()
  }

  override fun getAllToDos(): MutableList<UserToDo> {
    consolidateToDos()
    return list
  }

  private fun consolidateToDos() {
    //Kotlin
    Observable.just(true)
        .observeOn(Schedulers.computation())
        .map { dbManager?.getAllUserToDo() }
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.computation())
        .subscribe {
          it?.let {
            it.forEach {
              list.add(it)
            }
          }
        }
  }


  override fun inject(display: ListDisplayImpl) {
    this.display = display
    dbManager = DbManager(display.getContext())
  }
}