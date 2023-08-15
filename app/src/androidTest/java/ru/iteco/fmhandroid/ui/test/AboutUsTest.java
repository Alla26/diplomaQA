package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

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
import ru.iteco.fmhandroid.ui.pages.AboutUsPage;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки О приложении мобильного приложения Мобильный хоспис")
public class AboutUsTest {
    private final String item = "About";
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AboutUsPage aboutUsPage = new AboutUsPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));


   /* @Before
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
    }*/

    @Before
    public void setUp() {
       // Intents.init();
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

    /* @After
     public void tearDown(){
     Intents.release();
         mainPage.waitLogOutImage();
         mainPage.logOut();
         mainPage.clickLogOutButton();
        // Intents.release();
     }*/
    @Story("19. Переход по ссылке Политика конфиденциальности")
    @Description("Перейти по ссылке Политика конфиденциальности во вкладке О приложении мобильного приложения Мобильный хоспис и дождаться загрузки информации (Позитивный)")
    @Test
    public void followTheLinkPrivacyPolicyTest() {
        mainPage.clickMenuItem(item);
        Intents.init();
        aboutUsPage.clickPrivacyPolicyLink();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
        aboutUsPage.policyText.check(matches(isDisplayed()));
        pressBack();
    }

    @Story("20. Переход по ссылке Правила использования")
    @Description("Перейти по ссылке Правила использования во вкладке О приложении мобильного приложения Мобильный хоспис и дождаться загрузки информации (Позитивный)")
    @Test
    public void followTheLinkTermsOfUseTest() {
        mainPage.clickMenuItem(item);
        Intents.init();
        aboutUsPage.clickTermsOfUseLink();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
        aboutUsPage.termsOfUseText.check(matches(isDisplayed()));
        pressBack();
    }

}
