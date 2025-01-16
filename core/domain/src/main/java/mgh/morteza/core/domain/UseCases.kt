package mgh.morteza.core.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

abstract class NoResultUseCase<in P>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P) = withContext(dispatcher) { doWork(params) }

    protected abstract suspend fun doWork(params: P)
}

abstract class ResultUseCase<in P, out R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P): R = withContext(dispatcher) { doWork(params) }

    protected abstract suspend fun doWork(params: P): R
}

abstract class ObservableUseCase<out T>(private val dispatcher: CoroutineDispatcher) {

    operator fun invoke(): Flow<T> = createObservable().flowOn(dispatcher)

    protected abstract fun createObservable(): Flow<T>
}

abstract class SubjectUseCase<in P, out T>(private val dispatcher: CoroutineDispatcher) {
    // Ideally this would be buffer = 0, since we use flatMapLatest below, BUT invoke is not
    // suspending. This means that we can't suspend while flatMapLatest cancels any
    // existing flows. The buffer of 1 means that we can use tryEmit() and buffer the value
    // instead, resulting in mostly the same result.
    private val paramState = MutableSharedFlow<P>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    val flow: Flow<T> = paramState
        .distinctUntilChanged()
        .flatMapLatest { createObservable(it).flowOn(dispatcher) }

    operator fun invoke(params: P) {
        paramState.tryEmit(params)
    }

    protected abstract fun createObservable(params: P): Flow<T>
}

abstract class SuspendSubjectUseCase<P : Any, T>(dispatcher: CoroutineDispatcher) :
    SubjectUseCase<P, T>(dispatcher) {
    override fun createObservable(params: P): Flow<T> = flow {
        emit(doWork(params))
    }

    abstract suspend fun doWork(params: P): T
}
