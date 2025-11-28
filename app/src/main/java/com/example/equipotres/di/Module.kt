package com.example.equipotres.di

import android.content.Context
import androidx.room.Room
import com.example.equipotres.data.InventoryDB
import com.example.equipotres.data.InventoryDao
import com.example.equipotres.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideInventoryDB(@ApplicationContext context: Context):InventoryDB{
        return Room.databaseBuilder(
            context,
            InventoryDB::class.java,
            Constants.NAME_BD
        ).build()
    }

    @Singleton
    @Provides
    fun provideInventoyDao(inventoryDB: InventoryDB): InventoryDao {
        return inventoryDB.inventoryDao()
    }
}