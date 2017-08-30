package com.watchitforme.Item;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * Created by stuartburnside on 09/07/2016.
 */
public interface Item {

    BigDecimal getPriceFromHtml();

    String getDescriptionFromHtml();

    String getImageUrlFromHtml();
}
