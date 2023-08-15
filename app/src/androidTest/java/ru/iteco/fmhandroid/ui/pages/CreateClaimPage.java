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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class CreateClaimPage {
    private final int headerField = R.id.custom_app_bar_title_text_view;//заголовок страницы создания претензии
    private final int titleField = R.id.title_edit_text;//заголовок претензии
    private final int executorField = com.google.android.material.R.id.text_input_end_icon;//исполнитель претензии
    private final int dateField = R.id.date_in_plan_text_input_edit_text;//выбор даты
    private final int okButton = android.R.id.button1; //кнопка ОК
    //  private final int okButtonTime = android.R.id.button1; //кнопка ОК при выборе времени
    private final int timeField = R.id.time_in_plan_text_input_edit_text;//выбор времени
    private final int descriptionField = R.id.description_edit_text;//описание
    private final int saveButton = R.id.save_button;//кнопка сохранить


    /*  public void waitCreateClaimPage() {
        onView(isRoot()).perform(waitDisplayed(headerField, 5000));
    }*/
    @Step("Добавить заголовок новой Претензии")
    public void addClaimTitle(String title) {
        onView(withId(titleField))
                .perform(replaceText(title), closeSoftKeyboard());
    }

    @Step("Добавить описание новой Претензии")
    public void addClaimDescription(String description) {
        onView(withId(descriptionField))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    @Step("Выбрать исполнителя новой Претензии")
    public void chooseExecutor() {
        onView(allOf(withId(executorField), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText("Ivanov Ivan Ivanovich"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    @Step("Выбрать текущую дату новой Претензии")
    public void addClaimCurrentDate() {
        onView((withId(dateField))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    @Step("Выбрать текущее время новой Претензии")
    public void addClaimCurrentTime() {
        onView((withId(timeField))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    @Step("Добавить некорректную дату новой Претензии")
    public void addClaimInvalidDate(String date) {
        onView((withId(dateField))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }

    @Step("Добавить некорректное время новой Претензии")
    public void addClaimInvalidTime(String time) {
        onView((withId(timeField))).perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
    }

    @Step("Появление всплывающего сообщения об ошибке Неверные данные")
    public void checkToastErrorMessage(String messageError, View decorView) {        //всплывает ли сообщение об ошибке, приложение падает при сохранении
      /*  onView(withText(messageError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));*/             //  рабочий вариант

        // onView(allOf(withContentDescription(messageError), isDisplayed())); //старый вариант

        onView(allOf(IsInstanceOf.instanceOf(android.widget.TextView.class),
                withText(messageError)))
                .check(matches(isDisplayed()));

    }

    @Step("Сохранение новой Претензии")
    public void saveNewClaim() {        //сохранение новой претензии
        onView((withId(saveButton))).perform(scrollTo(), click());
    }
}
