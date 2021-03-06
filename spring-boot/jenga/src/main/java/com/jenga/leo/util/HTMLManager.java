package com.jenga.leo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class HTMLManager {

    private Document doc = null;

    public final String injectTextById(String id, String text, File htmlFile) {

        try {
            doc = Jsoup.parse(htmlFile, "UTF-8");
            doc.getElementById(id).text(text);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.html();

    }

    public final String injectTextById(String id, String text, String htmlText) {

            doc = Jsoup.parse(htmlText);
            doc.getElementById(id).text(text);

        return doc.html();

    }

    public final String getHtmlTextFromFile(File htmlFile) {

        try {
            doc = Jsoup.parse(htmlFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.html();

    }

}
