package com.watchitforme.Item;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by stuartburnside on 07/07/2016.
 */
public class SampleItemControllerTest {
//    @Test
//    public void addItemAcceptsAStringUrlAndStringUserId() throws Exception {
//        ItemController itemController = new ItemController();
//        assertThat(itemController.addItem("http://www.google.com", "0001"), notNullValue());
//    }

    @Test
    public void listItemsReturnsTwoItems() throws Exception {
        ItemController itemController = new ItemController();
        assertThat(itemController.listItems().size(), equalTo(2));
    }

    @Test
    public void getItemReturnsAnItem() throws Exception {
        ItemController itemController = new ItemController();
        assertThat(itemController.getItem("01"), instanceOf(SampleItem.class));
    }

    @Test
    public void getItemReturnsAnItemForTheGivenId() throws Exception {
        ItemController itemController = new ItemController();
        assertThat(itemController.getItem("02").getPrice(), CoreMatchers.equalTo(5.99));
    }

//    @Test
//    public void addItemReturnsAStringId() throws Exception {
//        ItemController itemController = new ItemController();
//        assertThat(itemController.addItem("http://news.bbc.co.uk", null), CoreMatchers.equalTo("0));
//    }

}