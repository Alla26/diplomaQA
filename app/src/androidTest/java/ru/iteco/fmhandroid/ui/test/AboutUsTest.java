package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AboutUsPage;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutUsTest {
    private final String item = "About";
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AboutUsPage aboutUsPage = new AboutUsPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Before
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
    public void followTheLinkPrivacyPolicyTest() {   //перейти по ссылке политика конфиденциальности
        mainPage.clickMenuItem(item);
        aboutUsPage.clickPrivacyPolicyLink();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        Intents.release();
        aboutUsPage.policyText.check(matches(isDisplayed()));
    }

    @Test
    public void followTheLinkTermsOfUseTest() {   //перейти по ссылке правила использования
        mainPage.clickMenuItem(item);
        aboutUsPage.clickTermsOfUseLink();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
        aboutUsPage.termsOfUseText.check(matches(isDisplayed()));
    }

}
