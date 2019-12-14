package codenevisha.com.cleanarchitecture.domain.usecase.article

import codenevisha.com.cleanarchitecture.data.source.pref.PrefeManager
import codenevisha.com.cleanarchitecture.data.source.pref.UserPreference
import codenevisha.com.cleanarchitecture.domain.usecase.base.BaseUseCase
import javax.inject.Inject

//
// Created by Ehsan Joon on 12/14/19.
// Copyright (c) 2019 Yara Mobile. All rights reserved.
//
class GetUserNameFromPref @Inject constructor(
    private val prefeManager: PrefeManager
) : BaseUseCase<String>() {

    override fun execute(): String {
        prefeManager.userPreference.putValue(
            UserPreference.KEY_USER_NAME,
            "EsiJoon"
        )
        return prefeManager.userPreference.getValue(
            UserPreference.KEY_USER_NAME,
            UserPreference.DEFAULT_USER_NAME
        ) as String
    }
}