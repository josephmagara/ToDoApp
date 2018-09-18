package com.example.josephmagara.todoapp.tests

import org.josephmagara.todo.android.activities.android.data.presenters.ToDoPresenter
import org.junit.Test

class ToDoPresenterUnitTest {

  private val presenter = ToDoPresenter()
  @Test
  fun createUserToDo(){
    val title = "Testing UserToDo Creation"
    presenter.createToDo(title)

    //One user to do ought to have been added to the list
    assert(presenter.getAllToDos().size == 1)

    assert(presenter.getAllToDos()[0].title == title)

  }

  @Test
  fun toggleUserToDoCompleteValue(){
    val title = "Toggle UserToDo"
    presenter.createToDo(title)

    //One user to do ought to have been added to the list
    assert(presenter.getAllToDos().size == 1)


    val todo = presenter.getAllToDos()[0]

    assert(todo.title == title)

    //When created, the completed value ought to be false
    assert(!todo.completed)

    presenter.toggleComplete(todo)

    //The completed value ought to be true at this point
    assert(todo.completed)

    presenter.toggleComplete(todo)

    //The completed value ought to be false at this poing
    assert(!todo.completed)

  }
}