package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AboutUsPage {

    // private final int versionField = R.id.about_version_value_text_view;
    private final int privacyPolicyLink = R.id.about_privacy_policy_value_text_view;
    private final int termsOfUseLink = R.id.about_privacy_policy_value_text_view;
    public final ViewInteraction policyText = onView(withText("Политика конфиденциальности"));
    public final ViewInteraction termsOfUseText = onView(withText("Пользовательское соглашение"));

    @Step("Переход по ссылке Политика конфиденциальности")
    public void clickPrivacyPolicyLink() {
        onView(withId(privacyPolicyLink)).perform(click());
    }

    @Step("Переход по ссылке Правила использования")
    public void clickTermsOfUseLink() {
        onView(withId(termsOfUseLink)).perform(click());
    }

  /*  public void waitAboutUsPage() {
        onView(isRoot()).perform(waitDisplayed(versionField, 5000));
    }*/
}
