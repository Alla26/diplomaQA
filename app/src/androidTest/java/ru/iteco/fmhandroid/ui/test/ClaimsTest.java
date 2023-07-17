package ru.iteco.fmhandroid.ui.test;


import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.ClaimsPage;
import ru.iteco.fmhandroid.ui.pages.CreateClaimPage;
import ru.iteco.fmhandroid.ui.pages.CreateNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.utils.Utilities;



@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsTest {

       // private final String title = "Претензия rrr";
        private final String item = "Claims";
        private final String invalidDate = "01.01.0001";
        private final String invalidTime = "25:70";
        private final String errorMessageWrongDate = "Invalid date!";
        private final String errorMessageWrongTime = "Invalid time!";
        private final MainPage mainPage = new MainPage();
        private final AuthorizationPage authorizationPage = new AuthorizationPage();
        private final CreateClaimPage createClaimPage  = new CreateClaimPage();
        private final ClaimsPage claimsPage  = new ClaimsPage();
        private final Utilities utility = new Utilities();
        public View decorView;

        @Rule
        public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
                new ActivityScenarioRule<>(AppActivity.class);


        @Before
        /*public void setUp() {
            authorizationPage.waitAuthorizationPage();
            authorizationPage.clickForLoginField();
            authorizationPage.inputTextForLoginField();
            authorizationPage.clickForPasswordField();
            authorizationPage.inputTextForPasswordField();
            authorizationPage.clickForSignInField();
            mainPage.waitMainPage();
        }*/

    public void setUp() {
        try {
            authorizationPage.waitAuthorizationPage();
            authorizationPage.clickForLoginField();
            authorizationPage.inputTextForLoginField();
            authorizationPage.clickForPasswordField();
            authorizationPage.inputTextForPasswordField();
            authorizationPage.clickForSignInField();
            mainPage.waitMainPage();
        } catch (Exception e) {
            mainPage.waitMainPage();
        }
    }

        @After
        public void tearDown(){
            mainPage.waitLogOutImage();
            mainPage.logOut();
            mainPage.clickLogOutButton();
        }

        @Test
        public void addNewClaimCurrentDataTest() {   //добавление новой претензии с текущей датой и временем
            String description = utility.getRandomNewsDescription();
            String title = utility.getRandomClaimTitle();
            claimsPage.addNewClaim();
            createClaimPage.addClaimTitle(title);
            createClaimPage.chooseExecutor();
            createClaimPage.addClaimCurrentDate();
            createClaimPage.addClaimCurrentTime();
           createClaimPage.addClaimDescription(description);
            createClaimPage.saveNewClaim();
            mainPage.clickMenuItem(item);
            claimsPage.waitClaimsPage();
           // mainPage.openClaimsPage();
           claimsPage.findAddedClaim(title);


           /* String description = utility.getRandomNewsDescription();
            claimsPage.addNewClaim();
            createClaimPage.addClaimTitle(title);
            createClaimPage.chooseExecutor();
            createClaimPage.addClaimCurrentDate();
            createClaimPage.addClaimCurrentTime();
            createClaimPage.addClaimDescription(description);
            createClaimPage.saveNewClaim();
            mainPage.clickMenuItem(item);
            claimsPage.waitClaimsPage();
            // claimsPage.findAddedClaim(title,0);
            claimsPage.findAddedClaim(description,0);*/
        }

    @Test
    public void addNewClaimCurrentDataMainMenuTest() {   //добавление новой претензии с текущей датой и временем через гл меню
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        mainPage.clickMenuItem(item);
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimCurrentDate();
        createClaimPage.addClaimCurrentTime();
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
       // mainPage.clickMenuItem(item);
       // mainPage.openClaimsPage();
        claimsPage.findAddedClaim(title);
    }

    @Test
    public void addNewClaimInvalidDateTest() {   //добавление новой претензии с некорректной датой
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimInvalidDate(invalidDate);
        createClaimPage.addClaimCurrentTime();
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        createClaimPage.checkToastErrorMessage(errorMessageWrongDate, decorView);
    }

    @Test
    public void addNewClaimInvalidTimeTest() {   //добавление новой претензии с некорректным временем
        String description = utility.getRandomNewsDescription();
        String title = utility.getRandomClaimTitle();
        claimsPage.addNewClaim();
        createClaimPage.addClaimTitle(title);
        createClaimPage.chooseExecutor();
        createClaimPage.addClaimCurrentDate();
        createClaimPage.addClaimInvalidTime(invalidTime);
        createClaimPage.addClaimDescription(description);
        createClaimPage.saveNewClaim();
        createClaimPage.checkToastErrorMessage(errorMessageWrongTime, decorView);
    }


}
