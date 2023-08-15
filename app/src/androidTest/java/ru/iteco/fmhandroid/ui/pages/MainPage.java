package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class MainPage {
    private final int mainMenu = R.id.main_menu_image_button;
    private final int quotesButton = R.id.our_mission_image_button;
    private final int logOutButton = android.R.id.title;
    private final int logOutImage = R.id.authorization_image_button;
    private final int allNewsBlock = R.id.all_news_text_view;
    private final int allClaimsBlock = R.id.all_claims_text_view;
    private final int logo = R.id.trademark_image_view;

    @Step("Переход с главной страницы во вкладку Все новости")
    public void openNewsPage() {
        onView(withId(allNewsBlock)).perform(click());
    }

    @Step("Переход с главной страницы во вкладку Все претензии")
    public void openClaimsPage() {
        onView(withId(allClaimsBlock)).perform(click());
    }

    @Step("Переход с главной страницы во вкладку Цитаты")
    public void openQuotesPage() {
        onView(withId(quotesButton)).perform(click());
    }

    @Step("Нажатие на иконку ЛК")
    public void logOut() {
        onView(withId(logOutImage)).perform(click());
    }

    @Step("Выход из профиля")
    public void clickLogOutButton() {
        onView(withId(logOutButton)).perform(click());
    }

    @Step("Ожидание загрузки вкладки Главная страница")
    public void waitMainPage() {
        onView(isRoot()).perform(waitDisplayed(logo, 5000));
    }

    @Step("Ожидание загрузки иконки ЛК")
    public void waitLogOutImage() {
        onView(isRoot()).perform(waitDisplayed(logOutImage, 5000));
    }

    @Step("Клик по заданному пункту меню {item}")
    public void clickMenuItem(String item) {
        onView(withId(mainMenu)).perform(click());
        onView(withText(item))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }


}
