import org.testng.asserts.SoftAssert;


class Ttest {
    private SoftAssert softAssert;

    public Ttest() {
    }

    public SoftAssert getSA() {
        if(softAssert == null) {
            System.out.println("null");
            softAssert = new SoftAssert();
        }
        return softAssert;
    }

    public SoftAssert checkTrue(boolean bool) {
        getSA().assertTrue(bool);
        return softAssert;
    }

    public void assertAllall() {
        try {
            getSA().assertAll();
        } finally {
            softAssert = null;
            System.out.println("ntllasdfasdf");
        }
    }
}

