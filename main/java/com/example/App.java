package com.example;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.util.Scanner;

import static com.example.GoogleDocPage.googleDocUrl;
import static com.example.GoogleDocPage.pasteToGoogleDoc;
import static com.example.Helpers.copyToClipboard;
import static com.example.PlaywrightActions.*;
import static com.example.VacancyPage.getDataFromVacancyPage;
import static com.example.VacancyPage.VacancyData;


public class App {

    //    static String vacancyPage = vacancyUrl;
    static String vacancyPage = "https://jobs.dou.ua/companies/extrawest/vacancies/239358/";
    static String googleDocPage = googleDocUrl;
    static int rowNumber = 10;

    public static void main(String[] args) throws InterruptedException {

        takeParamsFromConsole();

        BrowserContext browser = launchSlowMoChromeBrowser(100);
        // take data from vacancy page and copy it to clipboard
        Page page = navigateToPage(browser, vacancyPage);
        VacancyData vacancyData = getDataFromVacancyPage(page);
        copyToClipboard(vacancyData.strData());

        // try to paste data
        Page page2 = navigateToPage(browser, googleDocPage);
        pasteToGoogleDoc(page2, vacancyData, rowNumber);
//        Thread.sleep(5000);

        closeBrowserData();
    }

    static void takeParamsFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Provide vacancy URL on Dou: ");
        vacancyPage = in.nextLine().trim();
        System.out.print("Set row number to paste vacancy data: ");
        rowNumber = in.nextInt();
    }


}