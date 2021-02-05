package dev.jamile.supercharacters.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainDispatchersProvider :
    DispatchersProvider {
    override val main: CoroutineDispatcher = Main
    override val io: CoroutineDispatcher = IO
}