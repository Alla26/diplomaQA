package ru.iteco.fmhandroid.ui.test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utilities;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            authorizationPage.waitAuthorizationPage();
        } catch (Exception e) {
            mainPage.waitLogOutImage();
            mainPage.logOut();
            mainPage.clickLogOutButton();
        }
    }

    @Test
    public void successfulAuthorizationTest() {   //удачная авторизация
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        mainPage.waitLogOutImage();
    }

    @Test
    public void successfulLogOutTest() {   //удачный разлогин
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        mainPage.waitLogOutImage();
        mainPage.logOut();
        mainPage.clickLogOutButton();
    }

    @Test
    public void failedAuthorizationWrongLoginTest() {         // ошибка авторизации с логином log
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputIncorrectTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Test
    public void failedAuthorizationWrongPassTest() {         // ошибка авторизации с паролем pass
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputIncorrectTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Test
    public void failedAuthorizationSpaseWithLoginTest() {         // ошибка авторизации с логином + пробел
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputSpaseWithLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Test
    public void failedAuthorizationSpaseWithPasswordTest() {         // ошибка авторизации с паролем + пробел
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputSpaseWithPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Test
    public void failedAuthorizationEmptyFieldTest() {         //ошибка авторизации, пустые поля
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.emptyLogin();
        authorizationPage.clickForPasswordField();
        authorizationPage.emptyPassword();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageEmptyFieldText();
    }

    @Test
    public void failedAuthorizationCapsPasswordTest() {         // ошибка авторизации пароль с Заглавной буквы
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputCapsPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Test
    public void failedAuthorizationCapsLoginTest() {         // ошибка авторизации логин с Заглавной буквы
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputCapsLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

}