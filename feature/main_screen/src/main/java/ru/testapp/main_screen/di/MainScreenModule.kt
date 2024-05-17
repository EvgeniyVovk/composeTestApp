package ru.testapp.main_screen.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.testapp.main_screen.data.MainScreenRepositoryImpl
import ru.testapp.main_screen.domain.MainScreenRepository

@Module
@InstallIn(SingletonComponent::class)
interface MainScreenModule {

    @Binds
    fun bindMainScreenRepositoryImplToMainScreenRepository(
        mainScreenRepositoryImpl: MainScreenRepositoryImpl
    ): MainScreenRepository
}