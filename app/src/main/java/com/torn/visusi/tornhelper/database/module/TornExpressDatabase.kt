package com.torn.visusi.tornhelper.database.module

import androidx.room.Database
import androidx.room.RoomDatabase
import com.torn.visusi.tornhelper.database.module.dao.UserDao

@Database(
  entities = [UserDao::class],
  version = 7
)
abstract class TornExpressDatabase : RoomDatabase() {
  abstract fun usersDao(): UserDao

}