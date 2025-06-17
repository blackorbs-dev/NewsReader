package blackorbs.dev.newsreader.data.models

sealed interface Response<out T>{
    data class Error(val message: String): Response<Nothing>
    data class Success<out T>(val data: T?): Response<T>
}