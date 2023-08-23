package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainPage {
    private final int mainMenu = R.id.main_menu_image_button;
    private final int quotesButton = R.id.our_mission_image_button;
    private final int logOutButton = android.R.id.title;
    private final int logOutImage = R.id.authorization_image_button;
    private final int allNewsBlock = R.id.all_news_text_view;
    private final int logo = R.id.trademark_image_view;

    public void openNewsPage() {
        Allure.step("Переход с главной страницы во вкладку Все новости");
        onView(withId(allNewsBlock)).perform(click());
    }

    public void openQuotesPage() {
        Allure.step("Переход с главной страницы во вкладку Цитаты");
        onView(withId(quotesButton)).perform(click());
    }

    public void logOut() {
        Allure.step("Нажатие на иконку ЛК");
        onView(withId(logOutImage)).perform(click());
    }

    public void clickLogOutButton() {
        Allure.step("Выход из профиля");
        onView(withId(logOutButton)).perform(click());
    }

    public void waitMainPage() {
        Allure.step("Ожидание загрузки вкладки Главная страница");
        onView(isRoot()).perform(waitDisplayed(logo, 5000));
    }

    public void waitLogOutImage() {
        Allure.step("Ожидание загрузки иконки ЛК");
        onView(isRoot()).perform(waitDisplayed(logOutImage, 5000));
    }

    public void clickMenuItem(String item) {
        Allure.step("Клик по заданному пункту меню " + item);
        onView(withId(mainMenu)).perform(click());
        onView(withText(item))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }
}
