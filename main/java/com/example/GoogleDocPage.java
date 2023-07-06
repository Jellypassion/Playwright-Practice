package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.example.Helpers.copyToClipboard;
import static com.example.PlaywrightActions.pressArrowDown;
import com.example.VacancyPage.VacancyData;

public class GoogleDocPage {

    public static final String googleDocUrl = Pages.GDOC.url;
    //    public static final String dropdownArrowSelector = "#post-paste-menu div div div[class='goog-toolbar-menu-button-dropdown docs-gm-arrow postpaste-arrow goog-inline-block'] div";
//    public static final String dropdownArrowSelector = "div[xpath='1']";
    public static final String dropdownArrowButtonName = "Вставити форматування";
    public static final String dropdownArrowDivideOptionText = "Розділити текст на стовпці";
    //    public static final String dropdownArrowDivideOptionTextV2 = "Розділити текст на стовпці(E)";
    public static final String docsInsertMenuSelector = "#docs-insert-menu";
    public static final String docsInsertLinkItemName = "Посилання";


    public static void pasteToGoogleDoc(Page page, VacancyData vacancyData, int rowNumber) {
        pressArrowDown(page, rowNumber - 1);
        page.keyboard().press("Meta+V");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(dropdownArrowButtonName)).click();
        page.getByText(dropdownArrowDivideOptionText, new Page.GetByTextOptions().setExact(true)).click();
        page.keyboard().press("Escape");
        // make vacancy link look like hyperlink
        page.keyboard().press("ArrowRight");
        page.keyboard().press("ArrowRight");
        page.keyboard().press("Enter");
        page.keyboard().press("Enter");
        page.keyboard().press("ArrowUp");
        page.keyboard().press("ArrowLeft");
        page.keyboard().press("ArrowLeft");
        // paste company link
        page.keyboard().press("Meta+K");
        copyToClipboard(vacancyData.companyLink());
        page.keyboard().press("Meta+V");
        page.keyboard().press("Enter");
        page.keyboard().press("Enter");
    }

}