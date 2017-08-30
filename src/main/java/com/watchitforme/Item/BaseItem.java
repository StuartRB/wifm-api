package com.watchitforme.Item;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class BaseItem {
    String rawHtml;
    String url;

    public String getRawHtml() {
        if (rawHtml == null){
            fetchRawHtml(this.url);
        }
        return rawHtml;
    }

    private void fetchRawHtml(String url){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("USER-AGENT", "Mozilla/5.0");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        try {
            rawHtml = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        }
        catch (Exception ex){
            System.out.println(">>>" + ex.getMessage());
            throw new ItemNotFoundException("Unable to validate url");
        }
    }

}
