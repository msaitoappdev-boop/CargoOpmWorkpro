package com.msaitodev.cargo.opm.workpro.di

import com.msaitodev.core.common.config.AppAssetConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizConfigModule {

    @Provides
    @Singleton
    fun provideAppAssetConfig(): AppAssetConfig {
        return AppAssetConfig(
            assetDataDirectory = "quiz_data",
            totalExamQuestions = 30, // 運行管理者（貨物）試験の設問数
            passingScoreThreshold = 0.6f // 合格ラインは60%以上（かつ各科目1問以上）
        )
    }
}
