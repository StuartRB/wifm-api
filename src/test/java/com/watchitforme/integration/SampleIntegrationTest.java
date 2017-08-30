package com.watchitforme.integration;

import com.watchitforme.Application;
import com.watchitforme.Item.ItemRequest;
import com.watchitforme.Item.ItemResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class SampleIntegrationTest {

    @Value("${local.server.port}")
    int port;

    final String testUrl = "http://localhost:8080/getitem";
    final RestTemplate template = new RestTemplate();


    @Test
    public void AmazonTest(){
        System.out.println("Testing: Amazon");

        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setUrl("https://www.amazon.co.uk/dp/B01DFKBL68/ref=fs_bis");
        HttpEntity httpEntity = new HttpEntity(itemRequest);

        ResponseEntity<ItemResponse> response = template.exchange(testUrl,
                HttpMethod.POST,
                httpEntity,
                ItemResponse.class
        );

        assertThat(response.getBody().getDescription().length(), greaterThan(0));//, equalTo(""));
    }

    @Test
    public void ArgosTest(){
        System.out.println("Testing: Argos" +
                "");

        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setUrl("https://www.amazon.co.uk/dp/B01DFKBL68/ref=fs_bis");
        HttpEntity httpEntity = new HttpEntity(itemRequest);

        ResponseEntity<ItemResponse> response = template.exchange(testUrl,
                HttpMethod.POST,
                httpEntity,
                ItemResponse.class
        );

        assertThat(response.getBody().getDescription().length(), greaterThan(0));//, equalTo(""));
    }
}
