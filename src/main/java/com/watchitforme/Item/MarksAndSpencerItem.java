package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MarksAndSpencerItem extends BaseItem implements Item{

    public MarksAndSpencerItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("data-mapping=\"price\" data-value=\"", "\""));
        searchCriteria.startAndEndCollection.add(new StartEndStrings("itemprop=\"price\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("meta name=\"description\" content=\"", "\""));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("|",""));
        replacerList.add(new Replacer("M&S",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("property=\"og:image\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return "http:" + htmlParser.getString(searchCriteria);
    }
}
