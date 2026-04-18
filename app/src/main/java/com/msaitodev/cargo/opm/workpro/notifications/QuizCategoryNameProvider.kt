package com.msaitodev.cargo.opm.workpro.notifications

import android.content.Context
import com.msaitodev.cargo.opm.workpro.R
import com.msaitodev.quiz.core.domain.repository.CategoryNameProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * クイズアプリ向けのカテゴリ名称供給実装。
 * ディレクトリ名（ID）を、Hub層の strings.xml に定義された日本語名に変換します。
 */
@Singleton
class QuizCategoryNameProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : CategoryNameProvider {
    override fun getDisplayName(categoryId: String): String {
        val resId = when (categoryId) {
            "01_business_law" -> R.string.cat_01_business_law
            "02_vehicle_law" -> R.string.cat_02_vehicle_law
            "03_traffic_law" -> R.string.cat_03_traffic_law
            "04_labor_law" -> R.string.cat_04_labor_law
            "05_practical_knowledge" -> R.string.cat_05_practical_knowledge
            "unclassified" -> R.string.cat_unclassified
            else -> null
        }
        
        return if (resId != null) {
            context.getString(resId)
        } else {
            // マッピングがない場合は ID をそのまま返し、不備に気づきやすくする
            categoryId
        }
    }
}
