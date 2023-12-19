package workwork.test.chatwebsockets.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import workwork.test.chatwebsockets.core.Constants.BASE_URL
import workwork.test.chatwebsockets.data.ApiService
import workwork.test.chatwebsockets.data.local.MainDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService():ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMainDb(application: Application):MainDb=
        Room.databaseBuilder(application,MainDb::class.java,"database_db")
            .build()


}