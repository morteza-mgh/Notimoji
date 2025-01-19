package mgh.morteza.core.domain.interactor.note

import kotlinx.coroutines.CoroutineDispatcher
import mgh.morteza.core.common.annotation.Dispatcher
import mgh.morteza.core.common.annotation.NotimojiDispatchers
import mgh.morteza.core.domain.ResultUseCase
import mgh.morteza.core.domain.contract.NoteRepository
import mgh.morteza.core.model.Note
import javax.inject.Inject

class InsertRoomsUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
    @Dispatcher(NotimojiDispatchers.IO) private val dispatcher: CoroutineDispatcher
) : ResultUseCase<List<Note>, Array<Long>>(dispatcher) {
    override suspend fun doWork(params: List<Note>): Array<Long> =
        noteRepository.insertNotes(params)
}