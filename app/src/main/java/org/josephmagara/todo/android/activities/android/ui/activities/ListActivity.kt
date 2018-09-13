package org.josephmagara.todo.android.activities.android.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.josephmagara.todoapp.R

class ListActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    bindView()
  }

  private fun bindView() {

  }
}
