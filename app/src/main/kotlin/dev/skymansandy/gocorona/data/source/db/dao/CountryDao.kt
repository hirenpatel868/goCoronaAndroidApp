package dev.skymansandy.gocorona.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.skymansandy.gocorona.data.source.db.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countryDbList: CountryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countryDbList: List<CountryEntity>?)

    @Query("SELECT * FROM CountryData")
    fun getStats(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM CountryData ORDER BY cases DESC")
    fun getStatsSortedByCases(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM CountryData WHERE countryCode = :countryCode")
    fun getCountry(countryCode: String): Flow<CountryEntity?>

    @Query("SELECT * FROM CountryData WHERE name LIKE :searchQuery")
    fun getFilteredCountries(searchQuery: String): Flow<List<CountryEntity>?>
}