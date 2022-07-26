package cz.hajma.videoprehravac.domain.failures

import java.lang.Exception

/**
 * Base failure class for use in Either<Failure, T> objects.
 */
data class BaseFailure(val messages : List<String>, val exception : Exception? = null ) {
    fun appendMessages(message : String) {
        messages.plus(message)
    }
}