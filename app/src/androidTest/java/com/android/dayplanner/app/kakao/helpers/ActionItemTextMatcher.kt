package com.android.dayplanner.app.kakao.helpers

import android.content.ClipData
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ActionItemTextMatcher(private val itemName: String) : TypeSafeMatcher<ClipData.Item>() {
    override fun describeTo(description: Description) {
        description.appendText("action item with text: $itemName")
    }

    override fun matchesSafely(item: ClipData.Item): Boolean {
        return item.text == itemName
    }
}