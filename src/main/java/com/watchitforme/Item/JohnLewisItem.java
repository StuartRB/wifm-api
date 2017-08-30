package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JohnLewisItem extends BaseItem implements Item{

    public JohnLewisItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<span itemprop=\"price\" class=\"now-price\">","<"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("&pound;",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<title>", "</title>"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("|",""));
        replacerList.add(new Replacer("John Lewis",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        System.out.println("Getting House of Fraser Image");
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("property=\"og:image\" content=\"", "\""));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("?$preview$",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
