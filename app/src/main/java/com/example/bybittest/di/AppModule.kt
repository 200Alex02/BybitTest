package com.example.bybittest.di

import com.example.bybittest.data.remote.api.ByBitImpl
import com.example.bybittest.data.remote.api.BybitApi
import com.example.bybittest.data.repository.AnnouncementRepositoryImpl
import com.example.bybittest.domain.repository.AnnouncementRepository
import com.example.bybittest.domain.use_case.GetAnnouncementsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    @Singleton
    fun provideBybitApi(client: HttpClient): BybitApi = ByBitImpl(client)

    @Provides
    @Singleton
    fun provideGetAnnouncementUseCase(repository: AnnouncementRepository): GetAnnouncementsUseCase {
        return GetAnnouncementsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAnnouncementRepository(api: BybitApi): AnnouncementRepository {
        return AnnouncementRepositoryImpl(api)
    }
}