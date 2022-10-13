package com.android.dayplanner.app.kakao.tests

import com.android.dayplanner.app.kakao.helpers.Strings.customDate1
import com.android.dayplanner.app.kakao.helpers.Strings.customDescription1
import com.android.dayplanner.app.kakao.helpers.Strings.customTitle1
import com.android.dayplanner.app.kakao.screenobjects.CreateNewTaskScreen
import com.android.dayplanner.app.kakao.screenobjects.EmptyTaskListScreen
import com.android.dayplanner.app.kakao.screenobjects.TasksListScreen
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class CreateAllTaskTypesTest : SetUp() {
    @Test
    fun findMyTaskWithName() {
        onScreen<TasksListScreen>{
            actionClickOnAddTaskBtn()
        }
        onScreen<CreateNewTaskScreen> {
            actionCreateAllTaskTypes(customTitle1, customDescription1, customDate1)
        }
        onScreen<TasksListScreen>{
            assertTaskDataByText(customTitle1, customDescription1, customDate1)
            actionDeleteAllTasks()
        }
        onScreen<EmptyTaskListScreen> {
            assertionIsElementsDisplayed()
        }
        onScreen<EmptyTaskListScreen>{
            assertionIsElementsDisplayed()
        }
    }
}