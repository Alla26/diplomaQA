package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class CreateClaimPage {
    private final int titleField = R.id.title_edit_text;//заголовок претензии
    private final int executorField = com.google.android.material.R.id.text_input_end_icon;//исполнитель претензии
    private final int dateField = R.id.date_in_plan_text_input_edit_text;//выбор даты
    private final int okButton = android.R.id.button1; //кнопка ОК
    private final int timeField = R.id.time_in_plan_text_input_edit_text;//выбор времени
    private final int descriptionField = R.id.description_edit_text;//описание
    private final int saveButton = R.id.save_button;//кнопка сохранить

    public void addClaimTitle(String title) {
        Allure.step("Добавить заголовок новой Претензии");
        onView(withId(titleField))
                .perform(replaceText(title), closeSoftKeyboard());
    }

    public void addClaimDescription(String description) {
        Allure.step("Добавить описание новой Претензии");
        onView(withId(descriptionField))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    public void chooseExecutor() {
        Allure.step("Выбрать исполнителя новой Претензии");
        onView(allOf(withId(executorField), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText("Ivanov Ivan Ivanovich"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void addClaimCurrentDate() {
        Allure.step("Выбрать текущую дату новой Претензии");
        onView((withId(dateField))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    public void addClaimCurrentTime() {
        Allure.step("Выбрать текущее время новой Претензии");
        onView((withId(timeField))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    public void addClaimInvalidDate(String date) {
        Allure.step("Добавить некорректную дату новой Претензии");
        onView((withId(dateField))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }

    public void addClaimInvalidTime(String time) {
        Allure.step("Добавить некорректное время новой Претензии");
        onView((withId(timeField))).perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
    }

    public void checkToastErrorMessage(String messageError, View decorView) {
        Allure.step("Появление всплывающего сообщения об ошибке Неверные данные");
        onView(allOf(IsInstanceOf.instanceOf(android.widget.TextView.class),
                withText(messageError)))
                .check(matches(isDisplayed()));
    }

    public void saveNewClaim() {
        Allure.step("Сохранение новой Претензии");
        onView((withId(saveButton))).perform(scrollTo(), click());
    }
}
