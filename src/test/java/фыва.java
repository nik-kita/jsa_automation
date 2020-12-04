import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class фыва {
    Ttest ttest;

    @BeforeClass
    public void before() {
        ttest = new Ttest();
    }
    @Test
    public void test1() {
        ttest.checkTrue(false);
        ttest.assertAllall();
    }
    @Test
    public void test2() {
        ttest.checkTrue(true);
        ttest.assertAllall();
    }
    @Test
    public void test3() {
        ttest.checkTrue(true);
        ttest.assertAllall();
    }
}
