package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.Utilities;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import android.view.View;

import org.hamcrest.Matcher;


public class AuthorizationPage {

    /*public static ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    private static final int loginFieldId = R.id.login_text_input_layout;
    public static ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    public static ViewInteraction signInButton = onView(withId(R.id.enter_button));*/


    private static final int loginFieldId = R.id.login_text_input_layout;
    private static final int passwordField = R.id.password_text_input_layout;
    private static final int signInButton = R.id.enter_button;


    public static void waitAuthorizationPage() {
        onView(isRoot()).perform(waitDisplayed(loginFieldId, 5000));
    }


    public static void successfulLogIn(){    //успешная авторизация с корректными данными
        Utilities utility = new Utilities();
        onView(withId(loginFieldId)).perform(typeText(utility.getValidUser().getLogin()), closeSoftKeyboard());
        onView(withId(passwordField)).perform(typeText(utility.getValidUser().getPassword()), closeSoftKeyboard());
        onView(withId(signInButton)).perform(click());

    }

      /* public void UnsuccessfulLogInWrongLog(){   // ошибка авторизации с логином log
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithWrongLogin().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithWrongLogin().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());

    }

    public void UnsuccessfulLogInWrongPass(){ // ошибка авторизации с паролем pass
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithWrongPassword().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithWrongPassword().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());

    }

    public void UnsuccessfulLogInLogWithSpase(){   // ошибка авторизации с логином + пробел
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithSpaseLogin().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithSpaseLogin().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());

    }

    public void UnsuccessfulLogInPassWithSpase(){ // ошибка авторизации с паролем + пробел
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithSpasePassword().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithSpasePassword().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());

    }

    public void UnsuccessfulLogInEmptyFields(){    //ошибка авторизации, пустые поля
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserEmptyFields().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserEmptyFields().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());
    }

    public void UnsuccessfulLogInCapitalLetterPass(){    //ошибка авторизации пароль с Заглавной буквы
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithCapitalLetterPassword().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithCapitalLetterPassword().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());
    }

    public void UnsuccessfulLogInCapitalLetterLog(){    //ошибка авторизации логин с Заглавной буквы
        Utilities utility = new Utilities();
        AuthorizationPage.loginField.perform(typeText(utility.getNotValidUserWithCapitalLetterLogin().getLogin()), closeSoftKeyboard());
        AuthorizationPage.passwordField.perform(typeText(utility.getNotValidUserWithCapitalLetterLogin().getPassword()), closeSoftKeyboard());
        AuthorizationPage.signInButton.perform(click());
    }

    public void checkPopupErrorMessage(String text) {
        onView(allOf(withContentDescription(text), isDisplayed()));
    }*/

}
