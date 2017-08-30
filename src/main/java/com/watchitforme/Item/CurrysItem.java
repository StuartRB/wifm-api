package com.watchitforme.Item;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * Created by stuartburnside on 09/07/2016.
 */
public class CurrysItem extends BaseItem implements Item{

    public CurrysItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<meta property=\"og:price:amount\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<meta property=\"og:title\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("\"image\": \"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
