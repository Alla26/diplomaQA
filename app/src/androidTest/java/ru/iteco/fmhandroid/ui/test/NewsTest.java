package ru.iteco.fmhandroid.ui.test;


import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.CreateNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.Utilities;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки Новости мобильного приложения Мобильный хоспис")
public class NewsTest {

    private final String title = "Объявление";
    private final String item = "News";
    private final String invalidDate = "01.01.0001";
    private final String invalidTime = "25:70";
    private final String errorMessageWrongDate = "Invalid date!";
    private final String errorMessageWrongTime = "Invalid time!";
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final CreateNewsPage createNewsPage = new CreateNewsPage();
    private final NewsPage newsPage = new NewsPage();
    private final Utilities utility = new Utilities();
    public View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before

    public void setUp() {
        try {
            mainPage.waitMainPage();
        } catch (Exception e) {
            authorizationPage.waitAuthorizationPage();
            authorizationPage.clickForLoginField();
            authorizationPage.inputTextForLoginField();
            authorizationPage.clickForPasswordField();
            authorizationPage.inputTextForPasswordField();
            authorizationPage.clickForSignInField();
            mainPage.waitMainPage();
        }
    }
    @Story("10. Добавление новой новости с текущей датой и временем")
    @Description("Создание новой новости с текущей датой и временем во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void addNewNewsCurrentDataTest() {
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
        newsPage.findAddedNews(description, 0);
    }

    @Story("11. Добавление новой новости с текущей датой и временем через Главное меню")
    @Description("Создание новой новости с текущей датой и временем через вкладку Главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void addNewNewsCurrentDataMainMenuTest() {   //добавление новой новости через главное меню с текущей датой и временем
        String descriptionTwo = utility.getRandomNewsDescription();
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
        newsPage.findAddedNews(descriptionTwo, 0);
    }

    @Story("12. Фильтрация новостей по категориям")
    @Description("Фильтрация новостей по выбранной категории во вкладке Новости с помощью кнопки Фильтр мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void newsFilteringByCategoryTest() {
        mainPage.openNewsPage(); //all news
        newsPage.filterNewsButton();
        newsPage.chooseCategoryOfNews(title);
        newsPage.selectTheBeginningOfTheIntervalForTheFilter();
        newsPage.selectTheEndOfTheIntervalForTheFilter();
        newsPage.clickFilterNewsButton();
        newsPage.checkNewsCategory(title, 0);
    }

    @Story("13. Добавление новой новости с некорректной датой и корректным временем")
    @Description("Попытка создания новой новости с некорректной датой и корректным временем во вкладке Новости мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void addNewNewsInvalidDateTest() {
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

    @Story("14. Добавление новой новости с корректной датой и некорректным временем")
    @Description("Попытка создания новой новости с корректной датой и некорректным временем во вкладке Новости мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void addNewNewsInvalidTimeTest() {
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

