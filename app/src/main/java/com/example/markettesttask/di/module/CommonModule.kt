package com.example.markettesttask.di.module

import android.content.Context
import com.example.core.common.notification.FireBaseNotifications
import com.example.core.common.notification.Notifications
import com.example.core.common.resource_manager.ResourceManager
import com.example.core.common.resource_manager.ResourceManagerImpl
import com.example.core.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface CommonModule {


    @Binds
    fun bindNotifications(impl: FireBaseNotifications): Notifications

    companion object {

        @Provides
        @ApplicationScope
        fun providesResourceManager(context: Context): ResourceManager =
            ResourceManagerImpl(context)

    }


}