package com.watchitforme.Item;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Created by stuartburnside on 10/07/2016.
 */
public class ItemFactoryTest {

    @Test(expected = ItemNotFoundException.class)
    public void getItemTypeByUrlReturnsNull() throws Exception {
        assertThat(ItemFactory.GetItemTypeByUrl(""), is(nullValue()));
    }

    @Test
    public void getItemTypeByUrlReturnsAValidItemInstance() throws Exception {
        String url = "http://www.currys.co.uk/";
        assertThat(ItemFactory.GetItemTypeByUrl(url), instanceOf(CurrysItem.class));
    }

    @Test
    public void getItemTypeByUrlReturnsTescoItem() throws Exception {
        String url = "http://www.tesco.com/";
        assertThat(ItemFactory.GetItemTypeByUrl(url), instanceOf(TescoItem.class));
    }

    @Test
    public void getItemTypeByUrlReturnsArgosItem() throws Exception {
        String url = "http://www.argos.co.uk/";
        assertThat(ItemFactory.GetItemTypeByUrl(url), instanceOf(ArgosItem.class));
    }

    @Test
    public void getItemTypeByUrlReturnsBandQItem() throws Exception {
        String url = "http://www.diy.com/";
        assertThat(ItemFactory.GetItemTypeByUrl(url), instanceOf(BAndQItem.class));
    }

}