package ru.testapp.settings.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.testapp.settings.data.SettingsScreenRepositoryImpl
import ru.testapp.settings.domain.SettingsScreenRepository

@Module
@InstallIn(SingletonComponent::class)
interface SettingsModule {

    @Binds
    fun bindSettingsScreenRepositoryImplToSettingsScreenRepository(
        settingsScreenRepositoryImpl: SettingsScreenRepositoryImpl
    ): SettingsScreenRepository
}