package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseOfFraserItem extends BaseItem implements Item{

    public HouseOfFraserItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("currentPrice\" : \"","\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<title>", "</title>"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("-",""));
        replacerList.add(new Replacer("House of Fraser",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        System.out.println("Getting House of Fraser Image");
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<li class=\"coach\"><img src=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
