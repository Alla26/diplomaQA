package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.QuotesPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейс для проведения функционального тестирования вкладки Цитаты мобильного приложения Мобильный хоспис")
public class QuotesTest {
    private final MainPage mainPage = new MainPage();
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final QuotesPage quotesPage = new QuotesPage();
    private final String title = "\"Хоспис для меня - это то, каким должен быть мир.\"";
    private final String description = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.\" Юля Капис, волонтер";
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setUp() {
        try {
            mainPage.waitMainPage();
        } catch (Exception e) {
            authorizationPage.waitAuthorizationPage();
            authorizationPage.clickForLoginField();
            authorizationPage.inputTextForLoginField();
            authorizationPage.clickForPasswordField();
            authorizationPage.inputTextForPasswordField();
            authorizationPage.clickForSignInField();
            mainPage.waitMainPage();
        }
    }

    @Story("21. Открытие цитаты")
    @Description("Открытие цитаты в развернутом виде во вкладке Цитаты мобильного приложения Мобильный хоспис(Позитивный)")
    @Test
    public void openingQuoteTest() {
        mainPage.openQuotesPage();
        quotesPage.waitQuotesPage();
        quotesPage.openQuote(title, 0);
        quotesPage.checkTextQuote(description);
    }
}
