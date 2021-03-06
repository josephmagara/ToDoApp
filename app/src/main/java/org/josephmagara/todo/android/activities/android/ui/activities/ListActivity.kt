package org.josephmagara.todo.android.activities.android.ui.activities

import android.content.Context
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
import org.josephmagara.todo.android.activities.android.data.presenters.ToDoPresenter
import org.josephmagara.todo.android.activities.android.ui.adapters.ToDoAdapter

@Suppress("UNUSED_EXPRESSION")
class ListActivity : AppCompatActivity(), ListDisplayImpl {

  private var adapter: ToDoAdapter? = null
  private var presenter : ToDoPresenter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    presenter = ToDoPresenter()
    presenter?.inject(this)
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

  private fun createToDo(string: String){
    presenter?.createToDo(string)
  }

  override fun notifyAdapterOfDataChange() {
    adapter?.notifyDataSetChanged()
  }

  override fun getContext(): Context {
    return this
  }
}
