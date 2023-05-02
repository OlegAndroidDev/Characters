package com.oleg.anywhereapp.di

import com.oleg.anywhereapp.rest.BaseRepository
import com.oleg.anywhereapp.rest.BaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun providesRepo(
        repositoryImpl: BaseRepositoryImpl
    ): BaseRepository
}