package org.josephmagara.todo.android.activities.android.data.repository.injectors.components

import dagger.Component
import org.josephmagara.todo.android.activities.android.data.repository.databases.DbManager
import org.josephmagara.todo.android.activities.android.data.repository.injectors.modules.DatabaseModule

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent{
  fun inject(dbManger : DbManager)
}