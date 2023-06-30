package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import android.view.View;

import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class CreateClaimPage {
    private final int headerField = R.id.custom_app_bar_title_text_view;//заголовок страницы создания претензии
    private final int titleField = R.id.title_edit_text;//заголовок претензии
    private final int executorField = com.google.android.material.R.id.text_input_end_icon;//исполнитель претензии
    private final int dateField = R.id.date_in_plan_text_input_edit_text;//выбор даты
    private final int okButtonDate = android.R.id.button1; //кнопка ОК при выборе даты
    private final int timeField = R.id.time_in_plan_text_input_edit_text;//выбор времени
    private final int okButtonTime = android.R.id.button1; //кнопка ОК при выборе времени
    private final int descriptionField = R.id.description_edit_text;//описание
    private final int saveButton = R.id.save_button;//кнопка сохранить


    public void waitCreateClaimPage() {
        onView(isRoot()).perform(waitDisplayed(headerField, 5000));
    }

    public void addClaimTitle(String title) {        //добавление заголовка новой претензии
        onView(withId(titleField))
                .perform(replaceText(title), closeSoftKeyboard());
    }
    public void addClaimDescription(String description) {        //добавление описания новой претензии
        onView(withId(descriptionField))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    public void chooseExecutor() {   //выбрать исполнителя
        onView(allOf(withId(executorField), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText("Ivanov Ivan Ivanovich"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void addClaimCurrentDate() {        //выбрать текущую дату претензии для простоты
        onView((withId(dateField))).perform(click());
        onView((withId(okButtonDate))).perform(click());
    }

    public void addClaimCurrentTime() {        //выбрать текущее время претензии для простоты
        onView((withId(timeField))).perform(click());
        onView((withId(okButtonDate))).perform(click());
    }

    public void addClaimInvalidDate(String date) {        //добавить некорректную дату
        onView((withId(dateField))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }
    public void addClaimInvalidTime(String time) {        //добавить некорректное время
        onView((withId(timeField))).perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
    }

    public void checkToastErrorMessage(String messageError, View decorView) {        //всплывает ли сообщение об ошибке
        onView(withText(messageError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

        // onView(allOf(withContentDescription(messageError), isDisplayed()));
    }

    public void saveNewClaim() {        //сохранение новой претензии
        onView((withId(saveButton))).perform(scrollTo(), click());
    }
}
