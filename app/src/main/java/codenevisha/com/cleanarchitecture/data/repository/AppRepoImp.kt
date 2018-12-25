package codenevisha.com.cleanarchitecture.data.repository

import codenevisha.com.cleanarchitecture.domain.AppRepository
import codenevisha.com.cleanarchitecture.data.restful.ApiService


class AppRepoImp(
    val apiService: ApiService
) : AppRepository {


}