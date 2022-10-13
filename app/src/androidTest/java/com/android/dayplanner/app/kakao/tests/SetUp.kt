package com.android.dayplanner.app.kakao.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import com.android.dayplanner.app.ui.MainActivity
import org.junit.After
import org.junit.Before

open class SetUp {

    lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        activityScenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        if (this::activityScenario.isInitialized) {
            activityScenario.close()
        }
    }
}