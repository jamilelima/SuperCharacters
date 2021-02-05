package dev.jamile.supercharacters.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}