package dev.jamile.superheroes.utils.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class ScopedContextDispatchers(
    val scope: CoroutineScope,
    private val dispatchersProvider: DispatchersProvider
) {
    val main: CoroutineContext
        get() = scope.coroutineContext + dispatchersProvider.main
    val io: CoroutineContext
        get() = scope.coroutineContext + dispatchersProvider.io
}