package test_package.unit.user_mode.from_footer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main_package.engine.OnixLocator;
import main_package.ui.user_mode.page_objects.from_footer.Blog;
import main_package.ui.user_mode.JsaLoginBaseUiTestRunner;

public class BlogPageUiTest extends JsaLoginBaseUiTestRunner {
    Blog blogPO;
    @BeforeClass
    public void goBlockPage() {
        blogPO = homeLoginModePO.goMainPage().goBlogPageFromFooter();
    }

    @Test(dataProvider = "getBlogPageLocators")
    public void blogPageTest(OnixLocator[] locators) {
        for(OnixLocator locator : locators) {
            onixUiAssert.checkCountOfElementByLocator(locator, 1);
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
