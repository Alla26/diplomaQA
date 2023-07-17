package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
//import static androidx.test.espresso.action.ViewActions.typeText;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.not;

//import androidx.test.espresso.ViewAction;
//import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.Utilities;
import ru.iteco.fmhandroid.ui.utils.AuthorizationData;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utilities.childAtPosition;

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


    public void waitAuthorizationPage() {
        onView(isRoot()).perform(waitDisplayed(loginFieldId, 5000));
    }

    public void clickForLoginField() {
        onView((withId(loginFieldId))).perform(click());
    }

    public void clickForPasswordField() {
        onView((withId(passwordField))).perform(click());
    }

    public void clickForSignInField() {
        onView(withId(signInButton)).perform(click());;
    }

    public void inputTextForLoginField(){
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
        .perform(replaceText(data.getValidUser().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputTextForPasswordField(){
        onView(
                allOf(childAtPosition(childAtPosition(withId(passwordField), 0), 0), isDisplayed()))
                .perform(replaceText(data.getValidUser().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputIncorrectTextForLoginField(){             // ошибка авторизации с логином log
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void checkToastMessageText() {     //всплывающее сообщение об ошибке неверные данные
        onView(allOf(withContentDescription(errorMessageWrongData), isDisplayed()));
    }

    public void checkToastMessageEmptyFieldText() {     //всплывающее сообщение об ошибке пустые поля
        onView(allOf(withContentDescription(errorMessageEmptyField), isDisplayed()));
    }

    public void inputIncorrectTextForPasswordField(){             // ошибка авторизации с паролем pass
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithWrongPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputSpaseWithLoginField(){             // ошибка авторизации с логином + пробел
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpaseLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }
    public void inputSpaseWithPasswordField(){             // ошибка авторизации с паролем + пробел
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithSpasePassword().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }
    public void emptyLogin(){             //ошибка авторизации, пустой логин
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }
    public void emptyPassword(){             //ошибка авторизации, пустой логин
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserEmptyFields().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputCapsPasswordField(){             // ошибка авторизации пароль с Заглавной буквы
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterPassword().getPassword()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

    public void inputCapsLoginField(){             // ошибка авторизации логин с Заглавной буквы
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginFieldId), 0), 0), isDisplayed()))
                .perform(replaceText(data.getNotValidUserWithCapitalLetterLogin().getLogin()), closeSoftKeyboard())
                .perform(pressImeActionButton());
    }

}
