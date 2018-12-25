package codenevisha.com.cleanarchitecture.ui

import codenevisha.com.cleanarchitecture.domain.AppRepository
import codenevisha.com.cleanarchitecture.ui.base.BaseViewmodel


class HomeViewModel  constructor(private var appRepository: AppRepository) : BaseViewmodel() {
}