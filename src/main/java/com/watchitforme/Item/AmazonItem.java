package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AmazonItem extends BaseItem implements Item{

    public AmazonItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<span id=\"priceblock_ourprice\" class=\"a-size-medium a-color-price\">£","<"));
        searchCriteria.startAndEndCollection.add(new StartEndStrings("a-size-medium a-color-price\">","<"));
        searchCriteria.startAndEndCollection.add(new StartEndStrings("a-color-price guild_priceblock_ourprice\">","<"));
        searchCriteria.startAndEndCollection.add(new StartEndStrings("a-color-price offer-price a-text-normal\">","<"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("£",""));
        replacerList.add(new Replacer("\n",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("<title>", "</title>"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("&amp;","&"));
        replacerList.add(new Replacer(":",""));
        replacerList.add(new Replacer("Amazon.co.uk","-"));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("data-a-dynamic-image=\"{&quot;", "&quot;"));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }
}
