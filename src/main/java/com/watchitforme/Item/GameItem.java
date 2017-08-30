package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GameItem extends BaseItem implements Item{

    public GameItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("class=\"price\">","<"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("&pound;",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:title\" content=\"", "\""));
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<title>", "<"));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        System.out.println("Game Image");
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:image\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return "http:" + htmlParser.getString(searchCriteria);
    }
}
