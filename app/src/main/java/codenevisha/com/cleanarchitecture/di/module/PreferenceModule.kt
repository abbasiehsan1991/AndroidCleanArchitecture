package codenevisha.com.cleanarchitecture.di.module

import android.content.Context
import codenevisha.com.cleanarchitecture.data.source.pref.PrefeManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class PreferenceModule {

    @Provides
    @Singleton
    fun providePreferences(context: Context): PrefeManager {
        return PrefeManager(context)
    }

}