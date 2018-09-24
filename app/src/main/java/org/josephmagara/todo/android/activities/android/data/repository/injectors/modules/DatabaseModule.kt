package org.josephmagara.todo.android.activities.android.data.repository.injectors.modules
import android.content.Context
import dagger.Module
import dagger.Provides
import org.josephmagara.todo.android.activities.android.data.repository.databases.DbManager

@Module
class DatabaseModule(private val context: Context){

  @Provides
  fun providesDbManager() : DbManager{
    return DbManager(context)
  }
}