package com.torn.visusi.tornhelper.database.module.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<in T> {

  @Insert(onConflict = OnConflictStrategy.IGNORE) fun insert(entity: T)

  @Insert(onConflict = OnConflictStrategy.IGNORE) fun insert(vararg entity: T)

  @Insert(onConflict = OnConflictStrategy.IGNORE) fun insert(entities: List<T>)

  @Update fun update(entity: T)

  @Delete fun delete(entity: T)
}