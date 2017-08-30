package com.watchitforme.Item;

import org.junit.Test;
import org.springframework.cache.support.NullValue;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class HtmlParserTest {
    @Test
    public void getPriceReturnsAValidPriceWithValidCriteria() throws Exception {
        HtmlParser htmlParser = new HtmlParser("TEST13.99TEST2");
        SearchCriteria searchCriteria = new SearchCriteria();
        StartEndStrings startEndStrings = new StartEndStrings();
        startEndStrings.startString = "TEST1";
        startEndStrings.endString = "TEST2";
        searchCriteria.startAndEndCollection.add(startEndStrings);
        System.out.println(new BigDecimal(3.99).setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(htmlParser.getPrice(searchCriteria), new BigDecimal(3.99).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test(expected = ItemNotFoundException.class)
    public void getPriceThrowsItemNotFoundExceptionIfNoSearchCriteriaPassed() throws Exception{
        HtmlParser htmlParser = new HtmlParser("TEST13.99TEST2");
        SearchCriteria searchCriteria = new SearchCriteria();
        assertThat(htmlParser.getPrice(searchCriteria), equalTo(true));
    }

    @Test(expected = ItemNotFoundException.class)
    public void getPriceThrowsItemNotFoundExceptionIfNoSearchFound() throws Exception{
        HtmlParser htmlParser = new HtmlParser("TESxxx3.99TEST2");
        SearchCriteria searchCriteria = new SearchCriteria();
        StartEndStrings startEndStrings = new StartEndStrings();
        startEndStrings.startString = "TEST1";
        startEndStrings.endString = "TEST2";
        searchCriteria.startAndEndCollection.add(startEndStrings);
        assertThat(htmlParser.getPrice(searchCriteria), equalTo(0F));
    }


    @Test
    public void htmlParserConstructorTakesAString() throws Exception {
        String payload = "<html>test</html>";
        HtmlParser htmlParser = new HtmlParser(payload);
        assertThat(htmlParser.getPayload(), equalTo(payload));
    }

    @Test(expected = ItemNotFoundException.class)
    public void getPriceTakesASearchCriteriaObjectAsParameter() throws Exception {
        HtmlParser htmlParser = new HtmlParser("");
        SearchCriteria searchCriteria = new SearchCriteria();
        StartEndStrings startEndStrings = new StartEndStrings();
        startEndStrings.startString = "<class=price'";
        startEndStrings.endString = "'/>";
        searchCriteria.startAndEndCollection.add(startEndStrings);
        assertThat(htmlParser.getPrice(searchCriteria), equalTo(true));
    }

    @Test
    public void getDescription() throws Exception {

    }

}