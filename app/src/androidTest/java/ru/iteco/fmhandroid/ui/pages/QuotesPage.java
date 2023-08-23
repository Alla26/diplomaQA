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

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class QuotesPage {
    private final int missionLogo = R.id.our_mission_item_open_card_image_button;
    private final int openQuoteButton = R.id.our_mission_item_open_card_image_button;
    private final int descriptionQuoteField = R.id.our_mission_item_description_text_view;

    public void openQuote(String title, int position) {
        Allure.step("Открытие цитаты");
        onView(withIndex(withId(openQuoteButton), 0)).perform(click());
    }
    public void checkTextQuote(String description) {
        Allure.step("Проверка текста цитаты");
        onView(allOf(withId(descriptionQuoteField), withText(description), isDisplayed()));
    }
    public void waitQuotesPage() {
        Allure.step("Ожидание загрузки вкладки Цитаты");
        onView(isRoot()).perform(waitDisplayed(missionLogo, 5000));
    }

}
