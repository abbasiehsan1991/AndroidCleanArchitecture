package  codenevisha.com.cleanarchitecture.domain.model

/**
 * various error status to know what happened if something goes wrong with a repository call
 */
enum class ErrorStatus {
    /**
     * error in connecting to repository (Server or Database)
     */
    NO_CONNECTION,
    /**
     * error in sending request to the server
     */
    BAD_REQUEST,
    /**
     * error in getting value (Json Error, Server Error, etc)
     */
    BAD_RESPONSE,
    /**
     * Time out  error
     */
    TIMEOUT,
    /**
     * no data available in repository
     */
    EMPTY_RESPONSE,
    /**
     * an interval server error
     */
    INTERVAL_ERROR,
    /**
     * an unexpected error
     */
    NOT_DEFINED,
    /**
     * bad credential
     */
    UNAUTHORIZED
}