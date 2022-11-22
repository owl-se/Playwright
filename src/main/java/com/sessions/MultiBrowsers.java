package com.sessions;

import com.microsoft.playwright.*;

public class MultiBrowsers {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);

        BrowserContext browserContext1 = browser.newContext();
        Page p1 = browserContext1.newPage();
        p1.navigate("https://www.google.com");
        p1.fill("xpath=//input[@name='q']", "val");
        System.out.println(p1.title());

        BrowserContext browserContext2 = browser.newContext();
        Page p2 = browserContext2.newPage();
        p2.navigate("https://www.vk.com");
        System.out.println(p2.title());
    }
}
