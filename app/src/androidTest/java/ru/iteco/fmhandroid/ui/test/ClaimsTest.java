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
import ru.iteco.fmhandroid.ui.pages.ClaimsPage;
import ru.iteco.fmhandroid.ui.pages.CreateClaimPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utilities;


@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки Претензии мобильного приложения Мобильный хоспис")
public class ClaimsTest {

    // private final String title = "Претензия rrr";
    private final String item = "Claims";
    private final String invalidDate = "01.01.0001";
    private final String invalidTime = "25:70";
    private final String errorMessageWrongDate = "Invalid date!";
    private final String errorMessageWrongTime = "Invalid time!";
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final CreateClaimPage createClaimPage = new CreateClaimPage();
    private final ClaimsPage claimsPage = new ClaimsPage();
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
      /*  try {
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
    }*/
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

    /*   @After
       public void tearDown(){
           mainPage.waitLogOutImage();
           mainPage.logOut();
           mainPage.clickLogOutButton();
       }*/
    @Story("15. Добавление новой претензии с текущей датой и временем")
    @Description("Создание новой претензии с текущей датой и временем во вкладке Претензии мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void addNewClaimCurrentDataTest() {
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimCurrentDate();
        createClaimPage.addClaimCurrentTime();
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        mainPage.clickMenuItem(item);
        claimsPage.waitClaimsPage();
        // mainPage.openClaimsPage();
        claimsPage.findAddedClaim(title);


           /* String description = utility.getRandomNewsDescription();
            claimsPage.addNewClaim();
            createClaimPage.addClaimTitle(title);
            createClaimPage.chooseExecutor();
            createClaimPage.addClaimCurrentDate();
            createClaimPage.addClaimCurrentTime();
            createClaimPage.addClaimDescription(description);
            createClaimPage.saveNewClaim();
            mainPage.clickMenuItem(item);
            claimsPage.waitClaimsPage();
            // claimsPage.findAddedClaim(title,0);
            claimsPage.findAddedClaim(description,0);*/
    }

    @Story("16. Добавление новой претензии с текущей датой и временем через Главное меню")
    @Description("Создание новой претензии с текущей датой и временем через вкладку Главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void addNewClaimCurrentDataMainMenuTest() {
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        mainPage.clickMenuItem(item);
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimCurrentDate();
        createClaimPage.addClaimCurrentTime();
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        // mainPage.clickMenuItem(item);
        // mainPage.openClaimsPage();
        claimsPage.findAddedClaim(title);
    }

    @Story("17. Добавление новой претензии с некорректной датой и корректным временем")
    @Description("Попытка создания новой претензии с некорректной датой и корректным временем во вкладке Претензии мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void addNewClaimInvalidDateTest() {
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimInvalidDate(invalidDate);
        createClaimPage.addClaimCurrentTime();
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        createClaimPage.checkToastErrorMessage(errorMessageWrongDate, decorView);
    }

    @Story("18. Добавление новой претензии с корректной датой и некорректным временем")
    @Description("Попытка создания новой претензии с корректной датой и некорректным временем во вкладке Претензии мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void addNewClaimInvalidTimeTest() {
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimCurrentDate();
        createClaimPage.addClaimInvalidTime(invalidTime);
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        createClaimPage.checkToastErrorMessage(errorMessageWrongTime, decorView);
    }


}
