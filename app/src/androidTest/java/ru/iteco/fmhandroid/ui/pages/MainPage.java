package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage  {
    private static final int mainMenu = R.id.main_menu_image_button;
    private static final int quotesButton = R.id.our_mission_image_button;
    private static final int logOutButton = android.R.id.title;
    private static final int logOutImage = R.id.authorization_image_button;
    private static final int allNewsBlock = R.id.all_news_text_view;
    private static final int allClaimsBlock = R.id.all_claims_text_view;
    private static final int logo = R.id.trademark_image_view;


    public static void openNewsPage() {  //перейти с гл страницы во все новости
        onView(withId(allNewsBlock)).perform(click());
    }

    public static void openClaimsPage() {  //перейти с гл страницы во все претензии
        onView(withId(allClaimsBlock)).perform(click());
    }

    public static void openQuotesPage() {  //перейти с гл страницы в цитаты
        onView(withId(quotesButton)).perform(click());
    }

    public static void logOut() {  //выход из профиля
        onView(withId(logOutImage)).perform(click());
        onView(withId(logOutButton)).perform(click());
    }








}
