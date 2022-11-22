package com.sessions;

import com.microsoft.playwright.*;

public class LocatorTricks {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser = playwright.chromium().launch(launchOptions);

        BrowserContext browserContext = browser.newContext();
        Page p = browserContext.newPage();
        p.navigate("https://www.orangehrm.com/");
        Locator l = p.locator("text = CONTACT SALES").last();
        l.hover();
        l.click();


        p.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
        l = p.locator("select#Form_getForm_Country option");
        System.out.println(l.count());
//        for (int i = 0; i < l.count(); i++) {
//            System.out.println(l.nth(i).textContent());
//        }
        l.allTextContents().stream().forEach(c -> {
            System.out.println(c);
        });

        browser.close();
        playwright.close();

    }
}
