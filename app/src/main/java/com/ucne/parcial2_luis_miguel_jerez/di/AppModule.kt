package com.ucne.parcial2_luis_miguel_jerez.di

import android.content.Context
import androidx.room.Room
import com.ucne.parcial2_luis_miguel_jerez.data.local.database.PrioridadDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesPrioridades(@ApplicationContext AppContext: Context): PrioridadDataBase =
        Room.databaseBuilder(AppContext, PrioridadDataBase::class.java, "Prioridad.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providesDao(db: PrioridadDataBase) = db.dao()
}