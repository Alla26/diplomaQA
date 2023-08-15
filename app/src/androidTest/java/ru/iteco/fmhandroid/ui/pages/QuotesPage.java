package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;
import static ru.iteco.fmhandroid.ui.utils.Utilities.withIndex;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class QuotesPage {

    private final int missionButton = R.id.our_mission_image_button;
    private final int missionLogo = R.id.our_mission_item_open_card_image_button;
    private final int openQuoteButton = R.id.our_mission_item_open_card_image_button;
    private final int descriptionQuoteField = R.id.our_mission_item_description_text_view;

    // private final int openQuoteButton = R.id.our_mission_item_list_recycler_view;
    @Step("Открытие цитаты")
    public void openQuote(String title, int position) {
        onView(withIndex(withId(openQuoteButton), 0)).perform(click());

    }

    @Step("Проверка текста цитаты")
    public void checkTextQuote(String description) {
        onView(allOf(withId(descriptionQuoteField), withText(description), isDisplayed()));

        //  onView(allOf(withId(descriptionQuoteField), withText(description))).check(matches(withText(description)));

        // onView(allOf(withId(descriptionQuoteField), withText(description))).check(matches(isDisplayed()));

        /* ViewInteraction textView = onView(
                 allOf(withId(descriptionQuoteField), withText(description),
                         withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                         isDisplayed()));
         textView.check(matches(withText(description)));*/
    }

    @Step("Ожидание загрузки вкладки Цитаты")
    public void waitQuotesPage() {
        onView(isRoot()).perform(waitDisplayed(missionLogo, 5000));
    }

}
