package com.example.markettesttask.di

import android.content.Context
import com.example.core.common.dispatcher.Dispatcher
import com.example.core.common.dispatcher.DispatcherMainUI
import com.example.core.common.resource_manager.ResourceManager
import com.example.core.common.resource_manager.ResourceManagerImpl
import com.example.core.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
interface CommonModule {


    companion object {

        @Provides
        @ApplicationScope
        fun providesResourceManager(context: Context): ResourceManager =
            ResourceManagerImpl(context)

    }


}