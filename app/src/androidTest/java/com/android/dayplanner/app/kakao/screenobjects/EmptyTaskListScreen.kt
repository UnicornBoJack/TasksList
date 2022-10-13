package com.android.dayplanner.app.kakao.screenobjects

import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView

class EmptyTaskListScreen : Screen<EmptyTaskListScreen>() {
    private val noTasks = R.string.no_tasks
    private val imageView = KImageView { withId(R.id.imageView) }
    private val textView = KTextView { withId(R.id.textView) }

    fun assertionIsElementsDisplayed() {
        imageView.isDisplayed()
        textView.hasText(noTasks)
    }
}