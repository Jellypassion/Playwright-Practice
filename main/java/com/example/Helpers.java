package com.example;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helpers {
    public static void main(String[] args) throws InterruptedException {
//        LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse("2018-03-09"));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(2018, 3, 9)));
//        System.out.println(convertDate("30 июня 2023"));
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy")));
//        var date = "13 june";
//        System.out.println(convertDate(date));


    }

    public static String convertDate(String date) {
        Pattern pattern = Pattern.compile("[a-z]+$");
        Matcher matcher = pattern.matcher(date);

        var englishDate = switch (matcher.group()) {
            case "травня" -> date.replace("травня", "May");
            case "червня" -> date.replace("червня", "June");
            case "липня" -> date.replace("липня", "July");
            case "серпня" -> date.replace("серпня", "August");
            default -> throw new IllegalStateException("Unexpected value: " + matcher.group());
        };
        var givenDate = LocalDate.parse(englishDate, DateTimeFormatter.ofPattern("d MMMM yyyy"));
        return String.valueOf(givenDate);
    }

    public static void copyToClipboard(String data) {
        StringSelection stringSelection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

}
