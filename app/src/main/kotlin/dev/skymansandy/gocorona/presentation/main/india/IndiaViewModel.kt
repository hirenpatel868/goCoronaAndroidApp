package dev.skymansandy.gocorona.presentation.main.india

import androidx.lifecycle.viewModelScope
import dev.skymansandy.base.lifecycle.viewmodel.BaseViewModel
import dev.skymansandy.gocorona.domain.usecase.GetIndiaDataForUiUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class IndiaViewModel @Inject constructor(
    private val getIndiaDataForUiUseCase: GetIndiaDataForUiUseCase
) : BaseViewModel<IndiaState, IndiaEvent>() {

    init {
        viewModelScope.launch {
            getIndiaDataForUiUseCase().collect {
                viewState = it
            }
        }
    }
}