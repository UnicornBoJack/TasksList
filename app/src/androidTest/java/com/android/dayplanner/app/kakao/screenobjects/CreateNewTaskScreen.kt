package com.android.dayplanner.app.kakao.screenobjects

import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton

class CreateNewTaskScreen : Screen<CreateNewTaskScreen>() {
    private val generateLongTaskBtn = KButton { withId(R.id.button_createLongTempTask) }
    private val generateShortTaskBtn = KButton { withId(R.id.button_createShortTempTask) }
    private val saveTaskBtn = KButton { withId(R.id.button_saveTask) }
    private val titleInput = KEditText { withId(R.id.editText_title) }
    private val descriptionInput = KEditText { withId(R.id.editText_description) }
    private val dateInput = KEditText { withId(R.id.editText_taskDate) }

    fun actionCreateAllTaskTypes(title: String, description: String, date: String) {
        createSimpleTask(title, description, date)
        onScreen<TasksListScreen> {
            actionClickOnAddTaskBtn()
        }
        actionGenerateLongDummyTask()
        onScreen<TasksListScreen> {
            actionClickOnAddTaskBtn()
        }
        actionGenerateShortDummyTask()
    }

    fun createSimpleTask(title: String, description: String, date: String) {
        actionTypeTitle(title)
        actionTypeDescription(description)
        actionTypeDate(date)
        actionSaveTask()
    }

    private fun actionTypeTitle(text: String) {
        titleInput {
            clearText()
            typeText(text)
        }
        closeSoftKeyboard()
    }

    private fun actionTypeDescription(text: String) {
        descriptionInput {
            clearText()
            typeText(text)
        }
        closeSoftKeyboard()
    }

    private fun actionTypeDate(date: String) {
        dateInput {
            clearText()
            typeText(date)
        }
        closeSoftKeyboard()
    }

    fun actionGenerateLongDummyTask() {
        generateLongTaskBtn.click()
        actionSaveTask()
    }

    fun actionGenerateShortDummyTask() {
        generateShortTaskBtn.click()
        actionSaveTask()
    }

    private fun actionSaveTask() {
        saveTaskBtn.click()
    }
}