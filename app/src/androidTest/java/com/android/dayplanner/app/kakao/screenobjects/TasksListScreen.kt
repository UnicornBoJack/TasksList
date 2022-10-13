package com.android.dayplanner.app.kakao.screenobjects

import android.view.View
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class TasksListScreen : Screen<TasksListScreen>() {
    private val addTaskBtn = KButton { withId(R.id.floating_action_button) }
    private val deleteAllView = KView { withText(R.string.label_delete_all) }
    private val showTaskHistory = KView { withText(R.string.label_history) }
    private val yesView = KView { withText(R.string.yes) }

    //    private val openToolbarMenu = openContextualActionModeOverflowMenu()
    private val recyclerView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::TaskItems)
    })

    class TaskItems(parent: Matcher<View>) : KRecyclerItem<TaskItems>(parent) {
        val title = KTextView(parent) { withId(R.id.textView_title) }
        val description = KTextView(parent) { withId(R.id.textView_description) }
        val date = KTextView(parent) { withId(R.id.textView_date) }
        val deleteTaskButton = KImageView(parent) { withId(R.id.imageView_delete) }
        val completeTaskButton = KCheckBox(parent) { withId(R.id.checkBox) }
    }

//    fun assertIsToastMessagePresent(toastMessage: String) {
//        onToast(toastMessage).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//    }

    fun actionClickOnAddTaskBtn() {
        addTaskBtn.click()
    }

    fun actionClickOnRVByName(text: String) {
        recyclerView {
            childWith<TaskItems> {
                withDescendant {
                    withText(text)
                }
            } perform {
                title.click()
            }
        }
    }

    fun actionClickOnFirstRvChild() {
        recyclerView {
            firstChild<TaskItems> {
                title.click()
            }
        }
    }

    fun actionClickOnLastRvChild() {
        recyclerView {
            lastChild<TaskItems> {
                title.click()
            }
        }
    }

    fun assertFirstTaskData(titleText: String, descriptionText: String, dateText: String) {
        recyclerView {
            firstChild<TaskItems> {
                title.hasText(titleText)
                description.hasText(descriptionText)
                date.hasText(dateText)
            }
        }
    }

    fun assertLastTaskData(titleText: String, descriptionText: String, dateText: String) {
        recyclerView {
            lastChild<TaskItems> {
                title.hasText(titleText)
                description.hasText(descriptionText)
                date.hasText(dateText)
            }
        }
    }

    fun assertTaskDataByText(titleText: String, descriptionText: String, dateText: String) {
        recyclerView {
            childWith<TaskItems> {
                withDescendant {
                    withText(titleText)
                }
            } perform {
                title.hasText(titleText)
                description.hasText(descriptionText)
                date.hasText(dateText)
            }
        }
    }

    fun actionDeleteFirstTask() {
        recyclerView {
            firstChild<TaskItems> {
                deleteTaskButton.click()
            }
        }
    }

    fun actionDeleteLastTask() {
        recyclerView {
            lastChild<TaskItems> {
                deleteTaskButton.click()
            }
        }
    }

    fun actionDeleteTaskByName(titleText: String) {
        recyclerView {
            childWith<TaskItems> {
                withDescendant {
                    withText(titleText)
                }
            } perform {
                deleteTaskButton.click()
            }
        }
    }

    fun actionCompleteTaskByName(titleText: String) {
        recyclerView {
            childWith<TaskItems> {
                withDescendant {
                    withText(titleText)
                }
            } perform {
                completeTaskButton.click()
            }
        }
    }

    fun actionCompleteLastTask() {
        recyclerView {
            lastChild<TaskItems> {
                completeTaskButton.click()
            }
        }
    }

    fun actionCompleteFirstTask() {
        recyclerView {
            firstChild<TaskItems> {
                completeTaskButton.click()
            }
        }
    }

    fun actionOpenTaskHistory() {
        openContextualActionModeOverflowMenu()
        showTaskHistory.click()
    }

    fun actionDeleteAllTasks() {
        openContextualActionModeOverflowMenu()
        deleteAllView.click()
        yesView.click()
    }
}