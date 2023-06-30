package ru.iteco.fmhandroid.ui.test;


import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.CreateNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.Utilities;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsTest {

    private final String title = "Объявление";
    private final String item = "News";
    private final String invalidDate = "01.01.0001";
    private final String invalidTime = "25:70";
    private final String errorMessageWrongDate = "Invalid date!";
    private final String errorMessageWrongTime = "Invalid time!";
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final CreateNewsPage createNewsPage  = new CreateNewsPage();
    private final NewsPage newsPage  = new NewsPage();
    private final Utilities utility = new Utilities();
    public View decorView;

        @Rule
        public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
                new ActivityScenarioRule<>(AppActivity.class);


        @Before
       /* public void setUp() {
                authorizationPage.waitAuthorizationPage();
                authorizationPage.clickForLoginField();
                authorizationPage.inputTextForLoginField();
                authorizationPage.clickForPasswordField();
                authorizationPage.inputTextForPasswordField();
                authorizationPage.clickForSignInField();
                mainPage.waitMainPage();
        }*/

        public void setUp() {
            try {
                authorizationPage.waitAuthorizationPage();
                authorizationPage.clickForLoginField();
                authorizationPage.inputTextForLoginField();
                authorizationPage.clickForPasswordField();
                authorizationPage.inputTextForPasswordField();
                authorizationPage.clickForSignInField();
                mainPage.waitMainPage();
            } catch (Exception e) {
                mainPage.waitMainPage();
            }
        }

        @After
        public void tearDown(){
            mainPage.waitLogOutImage();
            mainPage.logOut();
            mainPage.clickLogOutButton();
        }

        @Test
        public void addNewNewsCurrentDataTest() {   //добавление новой новости с текущей датой и временем
            String description = utility.getRandomNewsDescription();
            mainPage.openNewsPage(); //all news
            newsPage.clickEditNews();
            newsPage.addNewNews();
            createNewsPage.chooseCategory(title);
            createNewsPage.addNewsCurrentDate();
            createNewsPage.addNewsCurrentTime();
            createNewsPage.addNewsDescription(description);
            createNewsPage.saveNewNews();
            mainPage.clickMenuItem(item);
            newsPage.waitNewsPage();
           // newsPage.sortNewsList();
            newsPage.findAddedNews(description,0);
        }

    @Test
    public void addNewNewsCurrentDataMainMenuTest() {   //добавление новой новости через главное меню с текущей датой и временем
        String descriptionTwo = utility.getRandomNewsDescription();
        //mainPage.waitMainPage();
        mainPage.clickMenuItem(item);
        newsPage.clickEditNews();
        newsPage.addNewNews();
        createNewsPage.chooseCategory(title);
        createNewsPage.addNewsCurrentDate();
        createNewsPage.addNewsCurrentTime();
        createNewsPage.addNewsDescription(descriptionTwo);
        createNewsPage.saveNewNews();
        mainPage.clickMenuItem(item);
        newsPage.waitNewsPage();
       // newsPage.sortNewsList();
        newsPage.findAddedNews(descriptionTwo,0);
    }

    @Test
    public void newsFilteringByCategoryTest() {   //фильтрация новостей по категориям
      //  String description = utility.getRandomNewsDescription();
        mainPage.openNewsPage(); //all news
        newsPage.filterNewsButton();
        newsPage.chooseCategoryOfNews(title);
        newsPage.selectTheBeginningOfTheIntervalForTheFilter();
        newsPage.selectTheEndOfTheIntervalForTheFilter();
        newsPage.clickFilterNewsButton();
       // newsPage.checkNewsCategory(title,0);

        /*createNewsPage.addNewsCurrentTime();
        createNewsPage.addNewsDescription(description);
        createNewsPage.saveNewNews();
        mainPage.clickMenuItem(item);
        newsPage.waitNewsPage();
        // newsPage.sortNewsList();
        newsPage.findAddedNews(description,0);*/
    }

    @Test
    public void addNewNewsInvalidDateTest() {   //добавление новой новости с некорректной датой
        String description = utility.getRandomNewsDescription();
        mainPage.openNewsPage(); //all news
        newsPage.clickEditNews();
        newsPage.addNewNews();
        createNewsPage.chooseCategory(title);
        createNewsPage.addNewsInvalidDate(invalidDate);
        createNewsPage.addNewsCurrentTime();
        createNewsPage.addNewsDescription(description);
        createNewsPage.saveNewNews();
        createNewsPage.checkToastErrorMessage(errorMessageWrongDate, decorView);
    }

    @Test
    public void addNewNewsInvalidTimeTest() {   //добавление новой новости с некорректным временем
        String description = utility.getRandomNewsDescription();
        mainPage.openNewsPage(); //all news
        newsPage.clickEditNews();
        newsPage.addNewNews();
        createNewsPage.chooseCategory(title);
        createNewsPage.addNewsCurrentDate();
        createNewsPage.addNewsInvalidTime(invalidTime);
        createNewsPage.addNewsDescription(description);
        createNewsPage.saveNewNews();
        createNewsPage.checkToastErrorMessage(errorMessageWrongTime, decorView);
    }

}

