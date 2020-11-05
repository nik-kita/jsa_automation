package ui.user_mode.from_footer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.engine.OnixLocator;
import ui.user_mode.page_objects.from_footer.Blog;
import ui.user_mode.JsaLoginBaseTestRunner;

public class BlogPageTest extends JsaLoginBaseTestRunner {
    Blog blogPO;
    @BeforeClass
    public void goBlockPage() {
        blogPO = homeLoginModePO.goMainPage().goBlogPageFromFooter();
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
