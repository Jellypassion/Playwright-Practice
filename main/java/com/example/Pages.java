package com.example;

public enum Pages {
    VACANCY("https://jobs.dou.ua/companies/kyivstar-tech/vacancies/151880/"),
    GDOC("https://docs.google.com/spreadsheets/d/1KtsKPejm_wAK9XShu9t87DOLtCSVAYLYCCwFyUxHtFY/edit?usp=sharing");

    final String url;
    Pages(String url) {
        this.url = url;
    }
}
