package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ClaimsPage {
    private final int addNewClaimButton = R.id.add_new_claim_material_button;
    private final int claimsList = R.id.claim_list_recycler_view;

    public void addNewClaim() {
        Allure.step("Добавить новую Претензию");
        onView(withId(addNewClaimButton)).perform(click());
    }

    public void waitClaimsPage() {
        Allure.step("Ожидание загрузки вкладки Претензии");
        onView(isRoot()).perform(waitDisplayed(claimsList, 10000));
    }

    public void findAddedClaim(String title) {
        Allure.step("Найти добавленную претензию через Все претензии");
        onView(ViewMatchers.withId(claimsList))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title)))).check(matches(isDisplayed()));
    }

}

