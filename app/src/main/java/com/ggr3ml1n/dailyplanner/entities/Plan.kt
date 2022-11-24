package com.ggr3ml1n.dailyplanner.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "plans_list")
data class Plan(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "date_start")
    val dateStart: Int,
    @ColumnInfo(name = "date_finish")
    val dateFinish: Int,
) : Serializable
