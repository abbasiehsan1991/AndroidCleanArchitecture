package  codenevisha.com.cleanarchitecture.domain.model

/**
 * Default error model that comes from server if something goes wrong with a repository call
 * This default error model can use for local storages too.
 */
data class ErrorModel(
        val message: String?,
        val code: Int?,
        @Transient var errorStatus: ErrorStatus
)