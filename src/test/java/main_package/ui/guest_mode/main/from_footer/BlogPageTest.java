package main_package.ui.guest_mode.main.from_footer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_package.test_engine.OnixTestRunner;
import main_package.ui.engine.OnixLocator;
import main_package.ui.guest_mode.page_objects.from_footer.Blog;

public class BlogPageTest extends OnixTestRunner {
    Blog blogPO;
    @BeforeClass
    public void goBlockPage() {
        blogPO = openSite().goBlogPageFromFooter();
    }

    @Test(dataProvider = "getBlogPageLocators")
    public void blogPageTest(OnixLocator[] locators) {
        for(OnixLocator locator : locators) {
            onixAssert.checkCountOfElementByLocator(locator, 1);
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