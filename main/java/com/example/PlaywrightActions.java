package com.example;

import com.microsoft.playwright.*;

public class PlaywrightActions {

    static Playwright playwright;
    static BrowserData browserData;

    public static BrowserContext launchSlowMoChromeBrowser(int millisecondsDelay) {
        playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(millisecondsDelay));
        System.out.println("Browser connected: " + browser.isConnected());
        BrowserContext context = browser.newContext();
        browserData = new BrowserData(browser, context);
        return context;
    }

    public static Page navigateToPage(BrowserContext context, String url) {
        Page page = context.newPage();
        page.navigate(url);
        return page;
    }

    public static void closeBrowserData() {
        try {
            browserData.context.close();
            browserData.browser.close();
            closePlaywright();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
        } else System.err.println("Playwright is null");
    }

    public static void pressArrowDown(Page page, int times) {
        var n = times;
        while (n > 0) {
            page.keyboard().press("ArrowDown");
            n--;
        }
    }

    record BrowserData(Browser browser, BrowserContext context) {
    }


}
