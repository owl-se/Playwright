package com.sessions;

import com.microsoft.playwright.*;

public class React {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);

        Page page = browser.newPage();
        page.navigate("https://ru.reactjs.org/");
        Locator l = page.locator("_react=i >> input").first();
        l.click();
        l.fill("ololo");

    }
}
