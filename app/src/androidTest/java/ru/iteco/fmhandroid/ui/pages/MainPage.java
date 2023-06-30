package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import org.junit.Test;

import ru.iteco.fmhandroid.R;

public class MainPage  {
    private final int mainMenu = R.id.main_menu_image_button;
    private final int quotesButton = R.id.our_mission_image_button;
    private final int logOutButton = android.R.id.title;
    private final int logOutImage = R.id.authorization_image_button;
    private final int allNewsBlock = R.id.all_news_text_view;
    private final int allClaimsBlock = R.id.all_claims_text_view;
    private final int logo = R.id.trademark_image_view;


    public void openNewsPage() {  //перейти с гл страницы во все новости
        onView(withId(allNewsBlock)).perform(click());

    }

    public void openClaimsPage() {  //перейти с гл страницы во все претензии
        onView(withId(allClaimsBlock)).perform(click());
    }

    public void openQuotesPage() {  //перейти с гл страницы в цитаты
        onView(withId(quotesButton)).perform(click());
    }

    public void logOut() {
       onView(withId(logOutImage)).perform(click());
    }
        public void clickLogOutButton(){  //выход из профиля
        onView(withId(logOutButton)).perform(click());
    }

    public void waitMainPage() {
        onView(isRoot()).perform(waitDisplayed(logo, 5000));
    }

    public void waitLogOutImage() {
        onView(isRoot()).perform(waitDisplayed(logOutImage, 5000));
    }

    public void clickMenuItem(String item) {                //кликнуть по заданному пункту меню
        onView(withId(mainMenu)).perform(click());
        onView(withText(item))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }


}
