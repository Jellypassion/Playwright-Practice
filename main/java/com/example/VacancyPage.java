package com.example;


import com.microsoft.playwright.Page;

import java.util.List;

public class VacancyPage {

    public static final String vacancyUrl = Pages.VACANCY.url;

    public static final String companyNameSelector = "//div[@class='l-n']/a[1]";
    public static final String vacancyNameSelector = "//div[@class='l-vacancy']/h1";
    public static final String dateSelector = "//div[@class='date']";

    public static VacancyData getDataFromVacancyPage(Page page) {
        var vacancyName = page.locator(vacancyNameSelector).textContent().replace(",", " ");
        var dataList = List.of(
                page.locator(companyNameSelector).textContent(),
                vacancyName,
                page.url(),
                page.locator(dateSelector).textContent().trim()
        );
        System.out.println("Vacancy data collected successfully:");
        System.out.println(dataList);
        var strValue = "";
        for (String it : dataList) {
            strValue = strValue.concat(it + ", ");
        }
        strValue = strValue.substring(0, strValue.length() - 2);
        var companyLink = page.locator(companyNameSelector).getAttribute("href");
        return new VacancyData(strValue, companyLink);
    }

    record VacancyData(String strData, String companyLink) {
    }

}
