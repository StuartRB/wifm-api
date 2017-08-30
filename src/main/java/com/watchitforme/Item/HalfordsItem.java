package com.watchitforme.Item;

import java.math.BigDecimal;

public class HalfordsItem extends BaseItem implements Item{

    public HalfordsItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("unit_price: \"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("name: \"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("property=\"og:image\" content=\"", "?"));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
