package com.watchitforme.Item;

import java.math.BigDecimal;
import java.util.List;

public class HtmlParser {
    private String payload;

    public HtmlParser(String payload) {
        payload = payload.replaceAll("^>[\\s]+<$","");
        payload = payload.replace("\n","");
        payload = payload.replace("\r","");
        payload = payload.replace("\t","");
        payload = payload.replaceAll(">\\s*<","><");
        this.payload = payload;
    }

    public BigDecimal getPrice(SearchCriteria searchCriteria) {
        String priceStr;

        for (StartEndStrings item : searchCriteria.startAndEndCollection) {

            priceStr = findBy(item.startString, item.endString, searchCriteria.replacers);

            if (priceStr != null) {
                BigDecimal price = new BigDecimal(priceStr.replace("£","").trim());
                price = price.setScale(2, BigDecimal.ROUND_HALF_UP);

                if (price.compareTo(BigDecimal.ZERO) > 0) {
                    return price;
                }
            }
        }
        throw new ItemNotFoundException("Unable to extract price from payload");
    }

    public String getString(SearchCriteria searchCriteria) {
        String value;

        for (StartEndStrings item : searchCriteria.startAndEndCollection) {

            value = findBy(item.startString, item.endString, searchCriteria.replacers);

            if(value != null){
                return value.trim();
            }
        }
        throw new ItemNotFoundException("Unable to extract description from payload");
    }

    public String getPayload() {
        return payload;
    }

    private String findBy(String start, String end, List<Replacer> replacers){
        int startPosition = payload.indexOf(start);

        if (startPosition > -1){
            String search = payload.substring(startPosition+start.length());
            Integer endPosition = search.indexOf(end);
            String returnString = search.substring(0, endPosition).trim();

            for(Replacer replacer : replacers){
                returnString = returnString.replace(replacer.getKey(), replacer.getValue());
            }

            return  returnString;
        }
        return null;
    }
}


