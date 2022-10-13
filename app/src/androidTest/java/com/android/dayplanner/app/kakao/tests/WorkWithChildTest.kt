package com.android.dayplanner.app.kakao.tests

import com.android.dayplanner.app.kakao.helpers.Strings.customDate1
import com.android.dayplanner.app.kakao.helpers.Strings.customDate2
import com.android.dayplanner.app.kakao.helpers.Strings.customDate3
import com.android.dayplanner.app.kakao.helpers.Strings.customDescription1
import com.android.dayplanner.app.kakao.helpers.Strings.customDescription2
import com.android.dayplanner.app.kakao.helpers.Strings.customDescription3
import com.android.dayplanner.app.kakao.helpers.Strings.customTitle1
import com.android.dayplanner.app.kakao.helpers.Strings.customTitle2
import com.android.dayplanner.app.kakao.helpers.Strings.customTitle3
import com.android.dayplanner.app.kakao.screenobjects.CreateNewTaskScreen
import com.android.dayplanner.app.kakao.screenobjects.TasksListScreen
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class WorkWithChildTest : SetUp() {
    @Test
    fun workWithChild() {
        onScreen<TasksListScreen> {
            actionClickOnAddTaskBtn()
        }
        onScreen<CreateNewTaskScreen> {
            createSimpleTask(customTitle1, customDescription1, customDate1)
        }
        onScreen<TasksListScreen> {
            actionClickOnAddTaskBtn()
        }
        onScreen<CreateNewTaskScreen> {
            createSimpleTask(customTitle2, customDescription2, customDate2)
        }
        onScreen<TasksListScreen> {
            actionClickOnAddTaskBtn()
        }
        onScreen<CreateNewTaskScreen> {
            createSimpleTask(customTitle3, customDescription3, customDate3)
        }
        onScreen<TasksListScreen> {
            assertFirstTaskData(customTitle3, customDescription3, customDate3)
            assertTaskDataByText(customTitle2, customDescription2, customDate2)
            assertLastTaskData(customTitle1, customDescription1, customDate1)
            actionDeleteFirstTask()
            actionDeleteLastTask()
            actionDeleteTaskByName(customTitle2)
        }
    }
}