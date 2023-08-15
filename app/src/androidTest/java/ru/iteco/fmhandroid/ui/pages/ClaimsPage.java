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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ClaimsPage {

    // private final int allClaimsButton = R.id.all_claims_text_view;
    private final int addNewClaimButton = R.id.add_new_claim_material_button;
    private final int claimsList = R.id.claim_list_recycler_view;
    private final int claimsDescriptionField = R.id.description_material_text_view;

    @Step("Добавить новую Претензию")
    public void addNewClaim() {
        onView(withId(addNewClaimButton)).perform(click());
    }

    @Step("Ожидание загрузки вкладки Претензии")
    public void waitClaimsPage() {
        onView(isRoot()).perform(waitDisplayed(claimsList, 10000));
    }

    @Step("Найти добавленную претензию через Все претензии")
    public void findAddedClaim(String title) {
       /* onView(withIndex(withId(claimsList), 1)).check(matches(isDisplayed()));
        onView(allOf(withId(claimsDescriptionField), withText(title)));*/

        onView(ViewMatchers.withId(claimsList))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title)))).check(matches(isDisplayed()));

        //  onView(withId(claimsDescriptionField)).check(matches(withText(title)));

        //  onView(withId(claimsList)).check(matches(isDisplayed()));

        // onView(withId(claimsList)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title)))).check(matches(isDisplayed()));
    }

}

