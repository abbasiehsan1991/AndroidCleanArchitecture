package  codenevisha.com.cleanarchitecture.domain.model



/**
 * base sealed class for handling BaseUseCase responses in [BaseUseCase]
 * @see [BaseUseCase]
 */
sealed class UseCaseResponse<out T>

/**
 * Wrapper for success response of repository calls
 */
data class SuccessResponse<out T>(val value: T): UseCaseResponse<T>()

/**
 * Wrapper for error response of repository calls
 */
data class ErrorResponse<out T>(val error: ErrorModel): UseCaseResponse<T>()