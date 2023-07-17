package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utilities.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {

    private final int missionButton = R.id.our_mission_image_button;
    private final int missionLogo = R.id.our_mission_item_open_card_image_button;
    private final int openQuoteButton = R.id.our_mission_item_open_card_image_button;
    private final int descriptionQuoteField = R.id.our_mission_item_description_text_view;
    // private final int openQuoteButton = R.id.our_mission_item_list_recycler_view;

    public void openQuote(String title, int position) {  //открыть цитату
        onView(withIndex(withId(openQuoteButton), 0)).perform(click());

    }

     public void checkTextQuote(String description) {  //проверить текст цитаты
         onView(allOf(withId(descriptionQuoteField), withText(description), isDisplayed()));

        //  onView(allOf(withId(descriptionQuoteField), withText(description))).check(matches(withText(description)));

        // onView(allOf(withId(descriptionQuoteField), withText(description))).check(matches(isDisplayed()));

        /* ViewInteraction textView = onView(
                 allOf(withId(descriptionQuoteField), withText(description),
                         withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                         isDisplayed()));
         textView.check(matches(withText(description)));*/
    }

    public void waitQuotesPage() {
        onView(isRoot()).perform(waitDisplayed(missionLogo, 5000));
    }

}
