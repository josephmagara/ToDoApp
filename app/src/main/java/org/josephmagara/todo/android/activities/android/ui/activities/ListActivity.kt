package org.josephmagara.todo.android.activities.android.ui.activities

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.josephmagara.todoapp.R
import kotlinx.android.synthetic.main.activity_list.textInput
import kotlinx.android.synthetic.main.activity_list.toDoRecycler
import org.josephmagara.todo.android.activities.android.data.interfaces.ListDisplayImpl
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.data.presenters.ToDoPresenter
import org.josephmagara.todo.android.activities.android.ui.adapters.ToDoAdapter
import java.util.Date

@Suppress("UNUSED_EXPRESSION")
class ListActivity : AppCompatActivity(), LifecycleObserver, ListDisplayImpl {


  private var adapter: ToDoAdapter? = null
  private var presenter : ToDoPresenter? = null

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    presenter = ToDoPresenter(this)
    setupAdapter()
    bindView()
  }

  private fun setupAdapter() {
    adapter = presenter?.let { ToDoAdapter(this, it.getAllToDos(), it) }
  }

  private fun bindView() {

    val linearLayoutManager = LinearLayoutManager(this)
    toDoRecycler.layoutManager = linearLayoutManager
    toDoRecycler.adapter = adapter


    textInput.setOnEditorActionListener { textView: TextView, i: Int, _: KeyEvent? ->
      if (i == EditorInfo.IME_ACTION_DONE) {
        createToDo(textView.text.toString())
        clearTextInput()
        true
      }
      false
    }
  }

  private fun clearTextInput() {
    textInput.setText("")
  }

  private fun createToDo(title: String) {
    val newSubtasks = MutableLiveData<MutableList<SubTask>>()
    val newTodo = UserToDo(title,
        newSubtasks, Date())
    addToDo(newTodo)
  }

  private fun addToDo(td: UserToDo){
    presenter?.addTodo(td)
  }

  override fun notifyAdapterOfDataChange() {
    adapter?.notifyDataSetChanged()
  }
}
