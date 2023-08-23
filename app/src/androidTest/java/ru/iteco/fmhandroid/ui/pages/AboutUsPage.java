package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutUsPage {
    private final int privacyPolicyLink = R.id.about_privacy_policy_value_text_view;
    private final int termsOfUseLink = R.id.about_privacy_policy_value_text_view;
    public final ViewInteraction policyText = onView(withText("Политика конфиденциальности"));
    public final ViewInteraction termsOfUseText = onView(withText("Пользовательское соглашение"));

    public void clickPrivacyPolicyLink() {
        Allure.step("Переход по ссылке Политика конфиденциальности");
        onView(withId(privacyPolicyLink)).perform(click());
    }

    public void clickTermsOfUseLink() {
        Allure.step("Переход по ссылке Правила использования");
        onView(withId(termsOfUseLink)).perform(click());
    }
}
