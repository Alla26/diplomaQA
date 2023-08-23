package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.childAtPosition;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.AuthorizationData;

public class AuthorizationPage {
    private final int loginFieldId = R.id.login_text_input_layout;
    private final int passwordField = R.id.password_text_input_layout;
    private final int signInButton = R.id.enter_button;
    private final String errorMessageWrongData = "Wrong login or password";
    private final String errorMessageEmptyField = "Login and password cannot be empty";
    AuthorizationData data = new AuthorizationData();

    public void waitAuthorizationPage() {
        Allure.step("Ожидание загрузки Страницы авторизации");
        onView(isRoot()).perform(waitDisplayed(loginFieldId, 5000));
    }

    public void clickForLoginField() {
        Allure.step("Клик в поле Логин");
        onView((withId(loginFieldId))).perform(click());
    }

    public void clickForPasswordField() {
        Allure.step("Клик в поле Пароль");
        onView((withId(passwordField))).perform(click());
    }

    public void clickForSignInField() {
        Allure.step("Клик по кнопке Войти");
        onView(withId(signInButton)).perform(click());
        ;
    }

    public void inputTextForLoginField() {
        Allure.step("Ввести корректный логин в поле Логин");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getValidUser().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputTextForPasswordField() {
        Allure.step("Ввести корректный пароль в поле Пароль");
        onView(
                allOf(childAtPosition(childAtPosition(withId(passwordField), 0), 0), isDisplayed()))
                .perform(replaceText(data.getValidUser().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputIncorrectTextForLoginField() {
        Allure.step("Ввести некорректный логин log в поле Логин");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void checkToastMessageText() {
        Allure.step("Появление всплывающего сообщения об ошибке Неверные данные");
        onView(allOf(withContentDescription(errorMessageWrongData), isDisplayed()));
    }

    public void checkToastMessageEmptyFieldText() {
        Allure.step("Появление всплывающего сообщения об ошибке Пустые поля");
        onView(allOf(withContentDescription(errorMessageEmptyField), isDisplayed()));
    }

    public void inputIncorrectTextForPasswordField() {
        Allure.step("Ввести некорректный пароль pass в поле Пароль");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputSpaseWithLoginField() {
        Allure.step("Ввести некорректный логин log + пробел в поле Логин");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpaseLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputSpaseWithPasswordField() {
        Allure.step("Ввести некорректный пароль pass + пробел в поле Пароль");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpasePassword().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void emptyLogin() {
        Allure.step("Оставить пустым поле Логин");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void emptyPassword() {
        Allure.step("Оставить пустым поле Пароль");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputCapsPasswordField() {
        Allure.step("Ввести некорректный пароль с заглавной буквы Password2 в поле Пароль");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputCapsLoginField() {
        Allure.step("Ввести некорректный логин с заглавной буквы Login2 в поле Логин");
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

}
