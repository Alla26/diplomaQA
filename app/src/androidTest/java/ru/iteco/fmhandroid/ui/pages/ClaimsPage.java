package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utilities.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class ClaimsPage {

    private final int allClaimsButton = R.id.all_claims_text_view;
    private final int addNewClaimButton = R.id.add_new_claim_material_button;
    private final int claimsList = R.id.claim_list_recycler_view;
    private final int claimsDescriptionField = R.id.description_material_text_view;
    public void addNewClaim() {  //добавить претензию
        onView(withId(addNewClaimButton)).perform(click());
    }

    public void waitClaimsPage() {
        onView(isRoot()).perform(waitDisplayed(claimsList, 10000));
    }

    public void findAddedClaim(String title) {  //найти добавленную претензию через список всех претензий
       /* onView(withIndex(withId(claimsList), 1)).check(matches(isDisplayed()));
        onView(allOf(withId(claimsDescriptionField), withText(title)));*/

        onView(ViewMatchers.withId(claimsList))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title)))).check(matches(isDisplayed()));

      //  onView(withId(claimsDescriptionField)).check(matches(withText(title)));

      //  onView(withId(claimsList)).check(matches(isDisplayed()));

      //  onView(withId(claimsList)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title)))).check(matches(isDisplayed()));
    }

}
