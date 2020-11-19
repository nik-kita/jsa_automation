package test_package.automation;

import io.qameta.allure.Allure;
import main_package.ui.related_sites.FacebookGroupPage;
import main_package.ui.user_mode.page_objects.home_header.home.*;
import main_package.ui.user_mode.page_objects.home_header.home.account.MyPlan;
import main_package.ui.user_mode.page_objects.home_header.learn.*;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Meals;
import main_package.ui.user_mode.page_objects.home_header.nutrition.Recipes;
import main_package.ui.user_mode.page_objects.home_header.nutrition.ShoppingLists;
import main_package.ui.user_mode.page_objects.home_header.workouts.Browse;
import main_package.ui.user_mode.page_objects.home_header.workouts.MyWorkouts;
import main_package.ui.user_mode.page_objects.home_header.workouts.Personalised;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.data.User;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.main.Main;
import main_package.ui.guest_mode.page_objects.main.login.Login;
import main_package.ui.user_mode.page_objects.home_header.home.my_goal.MyGoal;
import main_package.ui.user_mode.page_objects.home_header.home.my_progress.MyProgress;

public class WSAccount extends OnixTestRunner {
    Main main;

    @BeforeClass
    public void startFromMainPage() {
        main = openSite();
        log.info("open site");
    }

    @Test(testName = "Check base functionality of Home and relative pages")
    public void home() {
        Allure.link("Full test case information" , "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1204697450&range=B2");
        log.debug("Main page");
        for(OnixLocator l : Main.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        Login login = main.goLoginPage();
        log.debug("Login page");
        for(OnixLocator l : Login.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        Home home = login.login(User.getValidUser());
        log.debug("Home page");
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        MyGoal myGoal = home.clickMyGoalLink();
        for(OnixLocator l : MyGoal.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.debug("MyGoal page");
        log.debug("Remove all weekly goals if present");
        myGoal.removeAllWeeklyGoals();
        String goal_1 = "Make this world little better by test_package.automation all tests in the world!";
        String goal_2 = "If not in all world so on this site...";
        log.debug("Create two new weekly goals");
        myGoal = myGoal
                .clickNewGoalButton()
                .save(goal_1)
                .clickNewGoalButton()
                .save(goal_2);
        onixAssert.softCheckCountOfElementByLocator(myGoal.weeklyGoal, 2);
        myGoal.clickDeleteWeeklyGoal(goal_1);
        onixAssert.softCheckCountOfElementByLocator(myGoal.weeklyGoal,1 );
        log.debug("Remove one goal, check alert presence");
        onixAssert.softCheckCountOfElementByLocator(myGoal.doneGray, 1);
        myGoal.clickAcceptWeeklyGoal(goal_2);
        onixAssert.softCheckCountOfElementByLocator(myGoal.doneActive, 1);
        log.debug("Check activation checklist item");
        Steps steps = myGoal.clickBackArrow().clickStepsLink();
        log.debug("Steps page is open");
        for(OnixLocator l : Steps.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        MyProgress myProgress = steps.clickHomeTab().clickMyProgressLink();
        log.debug("MyProgress page is open");
        for(OnixLocator l : MyProgress.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        Challenges challenges = myProgress.clickBackArrow().clickChallenges();
        log.debug("Challenges page is open");
        for(OnixLocator l : Challenges.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.debug("Click 'Join Now' button");
        FacebookGroupPage facebookGroupPage = challenges.clickBackArrow().clickJoinNow();
        for(OnixLocator l : FacebookGroupPage.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l ,1);
        }
        log.debug("'FacebookGroup' page is open in another tab");
        log.debug("close 'FacebookGroup' tab and leave jsa tab");
        PersonalTrainer personalTrainer = new Home(facebookGroupPage.closeAndBackToJsaTab()).clickSupportButton();
        for(OnixLocator l : PersonalTrainer.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        main = personalTrainer.clickClose().openUserDropDown().logout().goMainPage();
        log.debug("Logout");
        onixAssert.assertAll();
    }

    @Test
    public void workouts() {
        Allure.link("Full test case information" , "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1204697450&range=B18");
                log.debug("1. Open https://www.jamessmithacademy.com/");
        Main main = openSite();
        for(OnixLocator l : Main.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("JSA home page is open");
        log.debug("2. Click on \"Login\" and pass an authorization");
        Home home = main.goLoginPage().login(User.getValidUser());
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Home page is open");
        log.debug("3. Click on \"Workouts\"");
        Personalised personalised = home.clickWorkoutsTab();
        for(OnixLocator l : Personalised.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Personalised tab is open by default");
        log.debug("5. Click on \"Browse\"");
        Browse browse = personalised.clickBrowseTab();
        for(OnixLocator l : Browse.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Browse tab is open");
        log.debug("6. Click on \"My Workouts\"");
        MyWorkouts myWorkouts = browse.clickMyWorkoutsTab();
        for(OnixLocator l : MyWorkouts.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("My workouts page is open");
        log.debug("7. Click on \"Support\"");
        PersonalTrainer personalTrainer = myWorkouts.clickSupportButton();
        for(OnixLocator l : PersonalTrainer.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Personal trainer is open");
        personalTrainer.clickClose().openUserDropDown().logout();
        onixAssert.assertAll();
        log.debug("Logout");
    }

    @Test
    public void learn() {
        Allure.link("Full test case information", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1204697450&range=B31");
        log.debug("1. Open https://www.jamessmithacademy.com/");
        Main main = openSite();
        log.info("JSA home page is open");
        log.debug("2. Click on \"Login\" and pass an authorization");
        Login login = main.goLoginPage();
        for(OnixLocator l : Login.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Login page is open");
        Home home = login.login(User.getValidUser());
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Successfully authorization");
        log.debug("3. Go to https://www.jamessmithacademy.com/users/#/learn or click on \"Learn\" page");
        Learn learn = home.clickLearnTab();
        for(OnixLocator l : Learn.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l,1);
        }
        log.info("Learn page is open");
        log.debug("4. Click on \"Find\" icon");
        SearchVideos searchVideos = learn.clickSearchIcon();
        for(OnixLocator l : SearchVideos.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Searching page is open");
        log.debug("5. Click on video in \"New Videos\" section");
        SingleLearnVideo singleLearnVideo = searchVideos.clickBackArrow().clickVideo();
        for(OnixLocator l : SingleLearnVideo.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Page with video is open");
        log.debug("6. Click on any category in \"Categories\" section\n" +
                "- Introducing\n" +
                "- Exercise Principles \n" +
                "- Nutrition Principles\n" +
                "- Exercises\n" +
                "- Mobility & Functions\n" +
                "- Social Media");
        CategoriesMultiPage categoriesMultiPage = singleLearnVideo.clickBackArrow().clickCategory();
        for(OnixLocator l : CategoriesMultiPage.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Exercises page is open");
        log.debug("7. Click on \"Favourites\"");
        Favourites favourites = categoriesMultiPage.clickBackArrow().clickFavourites();
        for(OnixLocator l : Favourites.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Favourites page is open");
        log.debug("8. Click on \"To Complete\"");
        ToComplete toComplete = favourites.clickBackArrow().clickToComplete();
        for(OnixLocator l : ToComplete.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("To complete page is open");
        log.debug("9. Click on \"Support\"");
        PersonalTrainer personalTrainer = toComplete.clickBackArrow().clickSupportButton();
        for(OnixLocator l : PersonalTrainer.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Personal trainer is open");
        personalTrainer.clickClose().openUserDropDown().logout();
        onixAssert.assertAll();
        log.debug("Logout");

    }

    @Test
    public void nutrition() {
        Allure.link("full test's steps link", "https://docs.google.com/spreadsheets/d/1gudjZ7fh4aUsozP7aPIovLnI4qGdbUFpIHJ6AbTlbC4/edit?ts=5f7593b0#gid=1204697450&range=B46");
        log.debug("1. Open https://www.jamessmithacademy.com/");
        Main main = openSite();
        for(OnixLocator l : Main.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("JSA main page is open");
        log.debug("2. Click on \"Login\" and pass an authorization");
        Home home = main.goLoginPage().login(User.getValidUser());
        for(OnixLocator l : Home.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("'Home' page is open");
        log.debug("3. Click on \"Nutrition\" page");
        Meals meals = home.clickNutritionTab();
        for(OnixLocator l : Meals.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("4. \"Meals\" page is open by default");
        log.debug("5. Click on \"Recipes\" ");
        Recipes recipes = meals.clickRecipesTab();
        for(OnixLocator l : Recipes.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Recipes page is open");
        log.debug("6. Click on \"Shopping List\"");
        ShoppingLists shoppingLists = recipes.clickShoppingListsTab();
        for(OnixLocator l : ShoppingLists.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Shopping List is open");
//        log.debug("7. Click on \"Support\"");
//        PersonalTrainer personalTrainer = shoppingLists.clickSupportButton();
//        for(OnixLocator l : PersonalTrainer.Locator.values()) {
//            onixAssert.softCheckCountOfElementByLocator(l, 1);
//        }
//        personalTrainer.clickClose().openUserDropDown().logout();
        //TODO is there 'Support button' or no?
        shoppingLists.openUserDropDown().logout();
        log.info("Logout");
    }

    @Test
    public void account() {
        log.debug("1. Open https://www.jamessmithacademy.com/\n2. Click on \"Login\" and pass an authorization\n3. Click on \"Account\" ");
        MyPlan myPlan = openSite().goLoginPage().login(User.getValidUser()).clickAccountIcon();
        for(OnixLocator l : MyPlan.Locator.values()) {
            onixAssert.softCheckCountOfElementByLocator(l, 1);
        }
        log.info("Account page is open and 'My Plan' tab is open by default");

    }

//    @Test
//    public void wtf() {
//        while(true) {
//            openSite().goLoginPage().login(User.getValidUser());
//            driver.findElement(HomeHeaderPart.HomeHeaderLocator.JSA_LOGO).click();
//            new main_package.ui.user_mode.page_objects.main.Main(driver).goHome()
//                    .openUserDropDown().logout();
//        }
//    }
}
