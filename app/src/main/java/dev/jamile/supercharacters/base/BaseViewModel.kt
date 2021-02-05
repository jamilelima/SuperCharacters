package dev.jamile.supercharacters.base

import androidx.lifecycle.ViewModel
import dev.jamile.supercharacters.utils.coroutines.DispatchersProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent

open class BaseViewModel(dispatchersProvider: DispatchersProvider) : ViewModel(), KoinComponent {

    private val viewModelJob = SupervisorJob()
    protected val scope = CoroutineScope(dispatchersProvider.io + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}