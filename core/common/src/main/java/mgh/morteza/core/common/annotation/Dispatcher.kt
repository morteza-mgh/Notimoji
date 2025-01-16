package mgh.morteza.core.common.annotation

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatcher: NotimojiDispatchers)

enum class NotimojiDispatchers { Main, IO, Default }
