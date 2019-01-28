package codenevisha.com.cleanarchitecture.data

import android.util.Log
import codenevisha.com.cleanarchitecture.domain.model.ErrorModel
import codenevisha.com.cleanarchitecture.domain.model.ErrorStatus
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class CloudErrorMapper @Inject constructor() {

    fun mapToDomainErrorException(throwable: Throwable?): ErrorModel {

        val errorModel = when (throwable) {

            // if throwable is an instance of HttpException
            // then attempt to parse error data from response body
            is HttpException -> {

                when {

                    //handle UNAUTHORIZED situation (when token expired)
                    throwable.code() == 401 -> ErrorModel(ErrorStatus.UNAUTHORIZED)

                    //handle Sending wrong request situation
                    throwable.code() == 400 -> ErrorModel(ErrorStatus.BAD_RESPONSE)

                    //handle interval server error situation
                    throwable.code() == 500 -> ErrorModel(ErrorStatus.INTERVAL_ERROR)

                    else -> getHttpError(throwable.response().errorBody())
                }
            }

            // handle api call timeout error
            is SocketTimeoutException -> {
                ErrorModel(ErrorStatus.TIMEOUT)
            }

            // handle connection error
            is IOException -> {
                ErrorModel(ErrorStatus.NO_CONNECTION)
            }

            else -> null
        }

        return errorModel!!
    }

    /**
     * attempts to parse http response body and get error data from it
     *
     * @param body retrofit response body
     * @return returns an instance of [ErrorModel] with parsed data or NOT_DEFINED status
     */
    private fun getHttpError(body: ResponseBody?): ErrorModel {

        return try {

            // use response body to get error detail
            val result = body?.string()

            Log.d("getHttpError", "getErrorMessage() called with: errorBody = [$result]")

            val json = Gson().fromJson(result, JsonObject::class.java)

            ErrorModel(json.toString(), null , ErrorStatus.BAD_RESPONSE)

        } catch (e: Throwable) {

            e.printStackTrace()
            ErrorModel(ErrorStatus.NOT_DEFINED)

        }
    }
}