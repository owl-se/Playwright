package com.sessions;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Basics {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser = playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();
        page.navigate("https://www.google.com");
        System.out.println(page.title());
        System.out.println(page.url());

        browser.close();
        playwright.close();

    }
}

