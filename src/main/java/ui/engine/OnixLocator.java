package ui.engine;

import org.openqa.selenium.By;

public interface OnixLocator {
    By getPath();
    String name();

    static OnixLocator makeOnixLocator(By path) {
        return new OnixLocator() {
            @Override
            public By getPath() {
                return path;
            }

            @Override
            public String name() {
                return Thread.currentThread().getStackTrace()[3].getClassName() + "\nLocator: " + path.toString();
            }
        };
    }
}
