package codenevisha.com.cleanarchitecture.domain.usecase.base

abstract class UseCase<T> {

    abstract fun execute():T

}