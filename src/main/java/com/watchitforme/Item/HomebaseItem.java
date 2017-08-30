package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HomebaseItem extends BaseItem implements Item{

    public HomebaseItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("itemprop=\"price\">", "<"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("&pound;",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        System.out.println("--B&Q Description");
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("property=\"og:title\" content=\"", "/"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("|",""));
        replacerList.add(new Replacer("Homebase",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        System.out.println("Homebase Image");
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:image\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return "http:" + htmlParser.getString(searchCriteria);
    }
}
