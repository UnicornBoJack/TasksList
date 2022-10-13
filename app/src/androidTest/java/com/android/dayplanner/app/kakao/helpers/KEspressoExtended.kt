package com.android.dayplanner.app.kakao.helpers

import android.widget.Toast
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.jens.automation2.matchers.ToastMatcher
import com.jens.automation2.matchers.ToastMatcher.Companion.onToast
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView

object KEspressoExtended {
    fun actionFindText(text: String) =
        KTextView { withText(text) }

//    fun actionCheckToast(toastText: String) {
//        val toast =KView {
//            withText(toastText)
//        } perform {
//            inRoot {
//                withMatcher(RootMatchers.isPlatformPopup())
//            }
//        }
//    }

//    fun actionCheckToast1(toastText: String) {
//        KView {
//            withText(toastText)
//        } perform {
//            inRoot {
//                withText(toastText)
//                ViewMatchers.isDisplayed()
//            }
//        }
//    }

//    fun kAssertIsToastMessagePresent(toastMessage: String) {
//        onToast(toastMessage).check(matches(isDisplayed()))
//    }

}