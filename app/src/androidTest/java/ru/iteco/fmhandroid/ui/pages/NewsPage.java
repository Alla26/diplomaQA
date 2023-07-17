package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static kotlinx.coroutines.flow.FlowKt.withIndex;
import static ru.iteco.fmhandroid.ui.utils.Utilities.waitDisplayed;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.R;

import android.view.View;

import org.hamcrest.Matcher;

import static ru.iteco.fmhandroid.ui.utils.Utilities.withIndex;

import java.security.cert.CertPathChecker;

public class NewsPage {
    private final int allNewsButton = R.id.all_news_text_view;
    private final int sortNewsButton = R.id.sort_news_material_button;
    private final int filterNewsButton = R.id.filter_news_material_button;
   // private final int canselFilterButton = R.id.cancel_button; //отмена фильтра
    private final int applyFilterButton = R.id.filter_button;// применить фильтр
    private final int editNewsButton = R.id.edit_news_material_button;
  //  private final int newsViaMainMenuButton = android.R.id.title;//новости через гл меню
    private final int addNewsButton = R.id.add_news_image_view;
   // private final int canselAddNewsButton = R.id.cancel_button;//отменить - не сохранять новую новость

   // private final int descriptionTextOfNews = R.id.news_item_description_text_view;

    private final int newsList = R.id.news_list_recycler_view;
    private final int newsTitleField = R.id.news_item_title_text_view;
    private final int newsDescriptionField = R.id.news_item_description_text_view;
    private final int newsPreview = R.id.news_item_material_card_view;
    private final int categoryButtonOfFilter = com.google.android.material.R.id.text_input_end_icon;



    public void addNewNews() {  //добавить новость
        onView(withId(addNewsButton)).perform(click());
    }

    public void clickEditNews() {  //перейти в редактирование новостей
        onView(withId(editNewsButton)).perform(click());
    }
    public void filterNewsButton() {  //фильтр новостей
        onView(withId(filterNewsButton)).perform(click());
    }

    public void clickAllNews() {  //перейти во все новости
        onView(withId(allNewsButton)).perform(click());
    }

    public void clickNewsSorting() {  //сортировать новости
        onView(withId(sortNewsButton)).perform(click());
    }

    public void sortNewsList() {  //сортировать новости
        onView(withId(sortNewsButton)).perform(click());
        onView(withId(sortNewsButton)).perform(click());
    }

    public void findAddedNews(String description, int position) {  //найти добавленную новость через список всех новостей без участия фильтра
        onView(withIndex(withId(newsPreview), 1)).check(matches(isDisplayed()));
        onView(allOf(withId(/*newsTitleField*/newsDescriptionField), withText(description)));

        //onView(withId(newsList)).perform(actionOnItemAtPosition(position, click()));
       // onView(allOf(withId(descriptionTextOfNews), withText(description))).check(matches(isDisplayed()));

        //onViewWithTimeout(10000, withId(newsList));
        //onView(allOf(withId(descriptionTextOfNews))).check(matches(hasDescendant(withText(description))));
    }

    public void checkNewsCategory(String title, int position) {  //проверить категорию новости в списке
        onView(withIndex(withId(newsPreview), 1)).check(matches(isDisplayed()));
        onView(allOf(withId(newsTitleField), withText(title))).check(matches(withText(title)));

        /*ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_title_text_view), withText(title),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(withText(title)));*/

      // onView(withIndex(withId(newsPreview), 1)).check(matches(isDisplayed()));
        /*  textView.check(matches(withText(title)));*/
    }
    public void waitNewsPage() {
        onView(isRoot()).perform(waitDisplayed(newsList, 5000));
    }

    public void chooseCategoryOfNews(String title) {   //выбрать категорию новости в фильтре
        onView(allOf(withId(categoryButtonOfFilter), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void selectTheBeginningOfTheIntervalForTheFilter() {        //выбрать начало интервала для фильтра
        onView((withId(R.id.news_item_publish_date_start_text_input_edit_text))).perform(click());
        onView((withId(android.R.id.button1))).perform(click());
    }

    public void selectTheEndOfTheIntervalForTheFilter() {        //выбрать конец интервала для фильтра
        onView((withId(R.id.news_item_publish_date_end_text_input_edit_text))).perform(click());
        onView((withId(android.R.id.button1))).perform(click());
    }

    public void clickFilterNewsButton() {  //подтвердить фильтр
        onView(withId(applyFilterButton)).perform(click());
    }
}


