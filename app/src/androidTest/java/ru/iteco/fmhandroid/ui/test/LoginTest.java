package ru.iteco.fmhandroid.ui.test;


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
import ru.iteco.fmhandroid.ui.pages.MainPage;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования авторизации и выхода из личного кабинета мобильного приложения Мобильный хоспис")
public class LoginTest {

    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

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

    @Story("1. Удачная попытка авторизации валидными данными")
    @Description("Удачная попытка авторизации валидными данными login2 и password2 через страницу авторизации мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void successfulAuthorizationTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        mainPage.waitLogOutImage();
    }

    @Story("2. Удачная попытка выхода из личного кабинета")
    @Description("Удачная попытка выхода из личного кабинета с помощью иконки ЛК мобильного приложения Мобильный хоспис (Позитивный)")
    @Test
    public void successfulLogOutTest() {
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

    @Story("3. Неудачная попытка авторизации невалидным логином и валидным паролем")
    @Description("Неудачная попытка авторизации невалидным логином log и валидным паролем password2 через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationWrongLoginTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputIncorrectTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Story("4. Неудачная попытка авторизации валидным логином и невалидным паролем")
    @Description("Неудачная попытка авторизации валидным логином login2 и невалидным паролем pass через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationWrongPassTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputIncorrectTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Story("5. Неудачная попытка авторизации валидным логином + пробел и валидным паролем")
    @Description("Неудачная попытка авторизации валидным логином login2 + SPASE и валидным паролем password2 через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationSpaseWithLoginTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputSpaseWithLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Story("6. Неудачная попытка авторизации валидным логином и валидным паролем + пробел")
    @Description("Неудачная попытка авторизации валидным логином login2 и валидным паролем password2 + SPASE через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationSpaseWithPasswordTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputSpaseWithPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Story("7. Неудачная попытка авторизации с пустыми полями Логин и Пароль")
    @Description("Неудачная попытка авторизации с пустыми полями Логин и Пароль через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationEmptyFieldTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.emptyLogin();
        authorizationPage.clickForPasswordField();
        authorizationPage.emptyPassword();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageEmptyFieldText();
    }

    @Story("8. Неудачная попытка авторизации валидным логином и невалидным паролем с Заглавной буквы")
    @Description("Неудачная попытка авторизации валидным логином login2 и невалидным паролем с Заглавной буквы Password2 через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationCapsPasswordTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputTextForLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputCapsPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

    @Story("9. Неудачная попытка авторизации невалидным логином с Заглавной буквы и валидным паролем")
    @Description("Неудачная попытка авторизации невалидным логином с Заглавной буквы Login2 и валидным паролем password2 через страницу авторизации мобильного приложения Мобильный хоспис (Негативный)")
    @Test
    public void failedAuthorizationCapsLoginTest() {
        authorizationPage.waitAuthorizationPage();
        authorizationPage.clickForLoginField();
        authorizationPage.inputCapsLoginField();
        authorizationPage.clickForPasswordField();
        authorizationPage.inputTextForPasswordField();
        authorizationPage.clickForSignInField();
        authorizationPage.checkToastMessageText();
    }

}