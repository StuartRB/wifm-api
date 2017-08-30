package com.watchitforme.Item;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class ItemService {
    public ItemResponse getItem(String url) {
        ItemResponse itemResponse = new ItemResponse();
        Item item = ItemFactory.GetItemTypeByUrl(url);

        itemResponse.setCurrentPrice(item.getPriceFromHtml());
        itemResponse.setDescription(item.getDescriptionFromHtml());
        itemResponse.setImageUrl(item.getImageUrlFromHtml());

        return itemResponse;
    }
}
