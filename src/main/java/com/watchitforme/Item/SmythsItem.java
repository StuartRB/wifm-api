package com.watchitforme.Item;

import java.math.BigDecimal;

public class SmythsItem extends BaseItem implements Item{

    public SmythsItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:price:amount\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:title\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("og:image\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
