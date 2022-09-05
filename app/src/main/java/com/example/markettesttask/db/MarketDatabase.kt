package com.example.markettesttask.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.markettesttask.BuildConfig

@Database(entities = [], version = 1)
abstract class MarketDatabase : RoomDatabase() {


    companion object {

        @Volatile
        private var INSTANCE: MarketDatabase? = null

        fun getInstance(context: Context): MarketDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MarketDatabase::class.java,
                        BuildConfig.DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}