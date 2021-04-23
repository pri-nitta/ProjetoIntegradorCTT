package com.ctt.projetointegradorctt.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_table")
data class Activities(
    @PrimaryKey @ColumnInfo(name = "title")
    val title: String? = "",
    @ColumnInfo(name = "description")
    var description: String? = ""
)