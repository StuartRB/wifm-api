package com.watchitforme.Item;

/**
 * Created by stuartburnside on 06/07/2016.
 */

import com.google.gson.Gson;
import com.watchitforme.ChuckNorris.ChuckNorris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/item")
    public List<SampleItem> listItems() {
        SampleItem a = new SampleItem("01", "A toy", 3.44);
        SampleItem b = new SampleItem("02", "Beanbag", 5.99);
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(a);
        sampleItems.add(b);

        return sampleItems;
    }

    @RequestMapping("/item/{id}")
    public SampleItem getItem(@PathVariable("id") String id) {
        switch (id) {
            case "01":
                return new SampleItem("01", "A toy", 3.44);
            case "02":
                return new SampleItem("02", "Beanbag", 5.99);
            default:
                return null;
        }
    }

    @RequestMapping(value = "/item", method=POST)
    @ResponseStatus(HttpStatus.OK)
    public ItemResponse getItem(@RequestBody ItemRequest itemRequest) throws UnsupportedEncodingException {
        System.out.println(itemRequest.getUrl());
        return itemService.getItem(itemRequest.getUrl());
    }

    @RequestMapping(value = "/item/{userid}", method=POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addItem(@PathVariable("userid") String userId, @RequestBody ItemRequest itemRequest) {
        Item item = ItemFactory.GetItemTypeByUrl(itemRequest.getUrl());

        return item.getPriceFromHtml().toString();
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleItemNotFoundException(ItemNotFoundException ex){
        return ex.getMessage();
    }
}
