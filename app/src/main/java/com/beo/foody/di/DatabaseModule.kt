package com.beo.foody.di

import android.content.Context
import androidx.room.Room
import com.beo.foody.data.database.RecipesDatabase
import com.beo.foody.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabse(@ApplicationContext context: Context): RecipesDatabase = Room.databaseBuilder(context, RecipesDatabase::class.java, Constants.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: RecipesDatabase) = database.recipesDao()
}