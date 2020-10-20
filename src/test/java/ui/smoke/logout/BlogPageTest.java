package ui.smoke.logout;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.OnixAssert;
import ui.OnixTestRunner;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.Blog;

public class BlogPageTest extends OnixTestRunner {
    Blog blogPO;
    @BeforeClass
    public void goBlockPage() {
        blogPO = openSite().goBlogPageFromFooter();
    }

    @Test(dataProvider = "getBlogPageLocators")
    public void blogPageTest(OnixLocator[] locators) {
        for(OnixLocator locator : locators) {
            new OnixAssert(driver).checkCountOfElementByLocator(locator, 1);
        }
    }
    @DataProvider
    public Object[] getBlogPageLocators() {
        return mergeArrays(
            Blog.Locator.values(),
            Blog.HeaderLocator.values(),
            Blog.FooterLocator.values()
        );
    }


}
