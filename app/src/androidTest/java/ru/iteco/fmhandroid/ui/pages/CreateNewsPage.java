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
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class CreateNewsPage {


    // private final int canselAddNewsButton = R.id.cancel_button;//отменить - не сохранять новую новость
    private final int saveNewsButton = R.id.save_button;   //сохранить новую новость
    private final int categoryButton = com.google.android.material.R.id.text_input_end_icon;//кнопка выпадающего меню категория
    private final int titleField = R.id.news_item_title_text_input_edit_text;//поле для залоговка
    private final int datePublication = R.id.news_item_publish_date_text_input_edit_text;//дата публикации
    private final int timePublication = R.id.news_item_publish_time_text_input_edit_text;//время публикации
    private final int descriptionField = R.id.news_item_description_text_input_edit_text;//поле для описания новости
    private final int okButton = android.R.id.button1; //кнопка ОК
    // private final int okButtonTime = android.R.id.button1; //кнопка ОК при выборе времени

    /*public void waitCreateNewsPage() {
        onView(isRoot()).perform(waitDisplayed(titleField, 5000));
    }*/
    @Step("Выбрать категорию новости {title}")
    public void chooseCategory(String title) {
        onView(allOf(withId(categoryButton), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    @Step("Выбрать текущую дату новой Новости")
    public void addNewsCurrentDate() {
        onView((withId(datePublication))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    @Step("Добавить некорректную дату новой Новости")
    public void addNewsInvalidDate(String date) {
        onView((withId(datePublication))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }

    @Step("Добавить некорректное время новой Новости")
    public void addNewsInvalidTime(String time) {
        onView((withId(timePublication))).perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
    }

    @Step("Появление всплывающего сообщения об ошибке Неверные данные")
    public void checkToastErrorMessage(String messageError, View decorView) {
        onView(withText(messageError))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

        // onView(allOf(withContentDescription(messageError), isDisplayed()));
    }

    @Step("Выбрать текущее время новой Новости")
    public void addNewsCurrentTime() {
        onView((withId(timePublication))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    @Step("Добавить описание новой новости {description}")
    public void addNewsDescription(String description) {
        onView(withId(descriptionField))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    @Step("Сохранение новой Новости")
    public void saveNewNews() {
        onView((withId(saveNewsButton))).perform(scrollTo(), click());
    }


}
