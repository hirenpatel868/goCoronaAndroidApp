package dev.skymansandy.gocorona.presentation.home

import dev.skymansandy.gocorona.presentation.home.adapter.CovidStat

sealed class HomeState {
    data class IndiaStats(
        val placeName: String,
        val lastUpdated: String,
        val confirmed: StatCard,
        val active: StatCard,
        val recovered: StatCard,
        val deceased: StatCard,
        val growthTrendMaxScale: Float,
        val stats: List<CovidStat>?
    ) : HomeState()

    data class NonIndiaStats(
        val placeName: String,
        val lastUpdated: String,
        val confirmed: StatCard,
        val active: StatCard,
        val recovered: StatCard,
        val deceased: StatCard
    ) : HomeState()

    object Loading : HomeState()
}

sealed class HomeEvent {
    data class CountryClicked(val countryId: String) : HomeEvent()
}

data class StatCard(
    var count: String = "",
    var deltaCount: String = "",
    var growthTrend: List<Int> = arrayListOf(0, 0)
)