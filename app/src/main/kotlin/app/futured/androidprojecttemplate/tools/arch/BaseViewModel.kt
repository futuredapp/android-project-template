package app.futured.androidprojecttemplate.tools.arch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.futured.arkitekt.core.ViewState
import app.futured.arkitekt.core.event.Event
import app.futured.arkitekt.crusecases.CoroutineScopeOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS : ViewState> : ViewModel(), CoroutineScopeOwner {
    abstract val viewState: VS

    override val coroutineScope: CoroutineScope = viewModelScope

    private val eventChannel = Channel<Event<VS>>(Channel.BUFFERED)
    val events = eventChannel
        .receiveAsFlow()
        .flowOn(Dispatchers.Main)

    fun sendEvent(event: Event<VS>) = viewModelScope.launch {
        eventChannel.send(event)
    }

    suspend inline fun observeEvents(
        crossinline observer: Event<VS>.() -> Unit
    ) {
        events.collect {
            observer(it)
        }
    }

    inline fun <reified E : Event<VS>> Event<VS>.onEvent(action: (E) -> Unit) {
        if (this is E) {
            action(this)
        }
    }
}
