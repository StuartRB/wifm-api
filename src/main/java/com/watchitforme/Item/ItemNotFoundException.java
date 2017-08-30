package com.watchitforme.Item;

/**
 * Created by stuartburnside on 11/07/2016.
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message){
        super(message);
    }
}
