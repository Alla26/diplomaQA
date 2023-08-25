package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utilities.withIndex;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsPage {
    private final int filterNewsButton = R.id.filter_news_material_button;
    private final int applyFilterButton = R.id.filter_button;// применить фильтр
    private final int editNewsButton = R.id.edit_news_material_button;
    private final int addNewsButton = R.id.add_news_image_view;
    private final int newsList = R.id.news_list_recycler_view;
    private final int newsTitleField = R.id.news_item_title_text_view;  //поле заголовка новости
    private final int newsDescriptionField = R.id.news_item_description_text_view;
    private final int newsPreview = R.id.news_item_material_card_view;
    private final int categoryButtonOfFilter = com.google.android.material.R.id.text_input_end_icon;


    public void addNewNews() {
        Allure.step("Добавить новую Новость");
        onView(withId(addNewsButton)).perform(click());
    }

    public void clickEditNews() {
        Allure.step("Перейти в редактирование Новостей");
        onView(withId(editNewsButton)).perform(click());
    }

    public void filterNewsButton() {
        Allure.step("Нажать на кнопку Фильтрация новостей");
        onView(withId(filterNewsButton)).perform(click());
    }
    public void findAddedNews(String description, int position) {
        Allure.step("Найти добавленную новость через Cписок всех новостей");
        onView(withIndex(withId(newsPreview), position)).check(matches(isDisplayed()));
        onView(allOf(withId(newsDescriptionField), withText(description)));
    }

    public void checkNewsCategory(String title, int position) {
        Allure.step("Проверить категорию новости в Списке");
        ViewInteraction textView = onView(
                allOf(withIndex(withId(newsTitleField), position),
                        isDisplayed()));
        textView.check(matches(withText(title)));
    }

    public void waitNewsPage() {
        Allure.step("Ожидание загрузки вкладки Новости");
        onView(isRoot()).perform(waitDisplayed(newsList, 5000));
    }

    public void chooseCategoryOfNews(String title) {
        Allure.step("Выбрать категорию новости " + title + " в Фильтре");
        onView(allOf(withId(categoryButtonOfFilter), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void selectTheBeginningOfTheIntervalForTheFilter() {
        Allure.step("Выбрать начало интервала для Фильтра (текущая дата)");
        onView((withId(R.id.news_item_publish_date_start_text_input_edit_text))).perform(click());
        onView((withId(android.R.id.button1))).perform(click());
    }

    public void selectTheEndOfTheIntervalForTheFilter() {
        Allure.step("Выбрать конец интервала для Фильтра (текущая дата)");
        onView((withId(R.id.news_item_publish_date_end_text_input_edit_text))).perform(click());
        onView((withId(android.R.id.button1))).perform(click());
    }

    public void clickFilterNewsButton() {
        Allure.step("Нажать на кнопку Применить фильтр");
        onView(withId(applyFilterButton)).perform(click());
    }
}


