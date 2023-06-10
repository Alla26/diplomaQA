package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.concurrent.TimeoutException;

import org.hamcrest.Matcher;

public class Utilities {

    public class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }
    public User getValidUser(){
        return new User("login2", "password2");
    }

    public User getNotValidUserWithWrongLogin(){
        return new User("log", "password2");
    }

    public User getNotValidUserWithWrongPassword(){
        return new User("login2", "pass");
    }

    public User getNotValidUserWithSpaseLogin(){
        return new User(" login2", "password2");
    }

    public User getNotValidUserWithSpasePassword(){
        return new User("login2", " password2");
    }

    public User getNotValidUserEmptyFields(){
        return new User("", "");
    }

    public User getNotValidUserWithCapitalLetterPassword(){
        return new User("login2", " Password2");
    }

    public User getNotValidUserWithCapitalLetterLogin(){
        return new User("Login2", " password2");
    }


    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> during " + millis + " millis.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> matchId = withId(viewId);
                final Matcher<View> matchDisplayed = isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };


    }
}
