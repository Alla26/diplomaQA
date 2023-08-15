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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.AuthorizationData;

//import android.view.View;

//import org.hamcrest.Matcher;
//import org.hamcrest.Matchers;


public class AuthorizationPage {
    private final int loginFieldId = R.id.login_text_input_layout;
    private final int passwordField = R.id.password_text_input_layout;
    private final int signInButton = R.id.enter_button;
    private final String errorMessageWrongData = "Wrong login or password";
    private final String errorMessageEmptyField = "Login and password cannot be empty";
    AuthorizationData data = new AuthorizationData();

    @Step("Ожидание загрузки Страницы авторизации")
    public void waitAuthorizationPage() {
        onView(isRoot()).perform(waitDisplayed(loginFieldId, 5000));
    }

    @Step("Клик в поле Логин")
    public void clickForLoginField() {
        onView((withId(loginFieldId))).perform(click());
    }

    @Step("Клик в поле Пароль")
    public void clickForPasswordField() {
        onView((withId(passwordField))).perform(click());
    }

    @Step("Клик по кнопке Войти")
    public void clickForSignInField() {
        onView(withId(signInButton)).perform(click());
        ;
    }

    @Step("Ввести корректный логин в поле Логин")
    public void inputTextForLoginField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getValidUser().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести корректный пароль в поле Пароль")
    public void inputTextForPasswordField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(passwordField), 0), 0), isDisplayed()))
                .perform(replaceText(data.getValidUser().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести некорректный логин log в поле Логин")
    public void inputIncorrectTextForLoginField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Появление всплывающего сообщения об ошибке Неверные данные")
    public void checkToastMessageText() {
        onView(allOf(withContentDescription(errorMessageWrongData), isDisplayed()));
    }

    @Step("Появление всплывающего сообщения об ошибке Пустые поля")
    public void checkToastMessageEmptyFieldText() {
        onView(allOf(withContentDescription(errorMessageEmptyField), isDisplayed()));
    }

    @Step("Ввести некорректный пароль pass в поле Пароль")
    public void inputIncorrectTextForPasswordField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести некорректный логин log + пробел в поле Логин")
    public void inputSpaseWithLoginField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpaseLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести некорректный пароль pass + пробел в поле Пароль")
    public void inputSpaseWithPasswordField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpasePassword().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Оставить пустым поле Логин")
    public void emptyLogin() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Оставить пустым поле Пароль")
    public void emptyPassword() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести некорректный пароль с заглавной буквы Password2 в поле Пароль")
    public void inputCapsPasswordField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    @Step("Ввести некорректный логин с заглавной буквы Login2 в поле Логин")
    public void inputCapsLoginField() {
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

}
