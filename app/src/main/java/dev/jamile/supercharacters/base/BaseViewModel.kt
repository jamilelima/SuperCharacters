package dev.jamile.superheroes.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jamile.superheroes.utils.coroutines.DispatchersProvider
import dev.jamile.superheroes.utils.coroutines.ScopedContextDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel(dispatchersProvider: DispatchersProvider) : ViewModel(), KoinComponent {

    private val viewModelJob = SupervisorJob()
    protected val scope = CoroutineScope(dispatchersProvider.io + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}