package dev.skymansandy.gocorona.presentation.districtdata

sealed class DistrictDataState {
    data class DistrictStats(
        val placeName: String,
        val lastUpdated: String,
        val active: Int,
        val confirmed: Int,
        val confirmedToday: Int,
        val recovered: Int,
        val recoveredToday: Int,
        val deaths: Int,
        val deathsToday: Int
    ) : DistrictDataState()

    object Loading : DistrictDataState()
}

sealed class DistrictDataEvent