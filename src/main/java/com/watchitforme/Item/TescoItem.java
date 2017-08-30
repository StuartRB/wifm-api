package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TescoItem extends BaseItem implements Item{

    public TescoItem(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getPriceFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("class=\"current-price\" itemprop=\"price\">","<"));
        List<Replacer> replacerList = new ArrayList<>();
        replacerList.add(new Replacer("&amp;","&"));
        replacerList.add(new Replacer(":",""));
        searchCriteria.replacers = replacerList;
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getPrice(searchCriteria);
    }

    @Override
    public String getDescriptionFromHtml(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("property=\"og:title\" content=\"", "\""));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        return htmlParser.getString(searchCriteria);
    }

    @Override
    public String getImageUrlFromHtml() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("scene7PdpData.s7ServerUrl = '", "'"));
        HtmlParser htmlParser = new HtmlParser(this.getRawHtml());
        String domain = "http:" + htmlParser.getString(searchCriteria);

        searchCriteria = new SearchCriteria();
        searchCriteria.startAndEndCollection.add(new StartEndStrings("scene7PdpData.s7ImageSet = '", ","));
        htmlParser = new HtmlParser(this.getRawHtml());
        return domain + htmlParser.getString(searchCriteria);
    }
}
