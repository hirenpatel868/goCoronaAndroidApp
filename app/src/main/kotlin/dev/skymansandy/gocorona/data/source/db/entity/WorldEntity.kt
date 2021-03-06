package dev.skymansandy.gocorona.data.source.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.skymansandy.base.util.date.DateUtil

@Entity(tableName = "WorldData")
data class WorldEntity(
    @PrimaryKey
    val id: Long = 0L,
    val cases: Int,
    val casesToday: Int,
    val deceased: Int,
    val deceasedToday: Int,
    val recovered: Int,
    val recoveredToday: Int,
    val active: Int,
    val critical: Int,
    val tests: Int,
    val testsPerOneMillion: String,
    val population: Long,
    val updated: Long
) {
    val lastUpdatedUiStr get() = DateUtil.getDateInFormat(updated)
}